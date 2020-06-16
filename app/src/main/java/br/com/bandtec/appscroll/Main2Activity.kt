package br.com.bandtec.appscroll

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.bandtec.appscroll.clientes.ClienteJsonPlaceholderApi
import br.com.bandtec.appscroll.modelos.Usuario
import feign.FeignException

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // teste local, sem consumo de API
        /*val usuarios = listOf<Usuario>(
            Usuario(1,"Ohashi", "ohashi@gmail.com"),
            Usuario(2,"Matheuszinho", "mtz@gmail.com"),
            Usuario(3,"Igor", "igor@gmail.com")
        )*/


        val requisicao = object : AsyncTask<Void, Void, List<Usuario>>() {

            override fun doInBackground(vararg p0: Void?): List<Usuario> {
                try {
                    return ClienteJsonPlaceholderApi.criarClienteUsuarios().getUsuarios()
                } catch (e:FeignException) {
                    Log.e("api", "Erro na busca de usuário na API: Status ${e.status()} / ${e.message}")
                    e.printStackTrace()
                    return emptyList()
                }
            }

        }

        val usuarios = requisicao.execute().get()

        if (usuarios.isEmpty()) {
            Toast.makeText(this, "Deu ruim, chame o suporte!", Toast.LENGTH_SHORT).show()
            return
        }

        val transaction = supportFragmentManager.beginTransaction()
        usuarios.forEach {
            val parametros = Bundle()
            parametros.putSerializable("usuario", it)

            val fragmento = ItemFragmento()
            fragmento.arguments = parametros

            transaction.add(R.id.layout_scroll, fragmento)
        }
        transaction.commit()
    }
}
