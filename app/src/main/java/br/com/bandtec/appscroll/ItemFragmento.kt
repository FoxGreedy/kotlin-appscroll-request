package br.com.bandtec.appscroll

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bandtec.appscroll.modelos.Usuario
import kotlinx.android.synthetic.main.fragment_item_fragmento.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ItemFragmento.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ItemFragmento.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ItemFragmento : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_fragmento, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val usuario = arguments?.get("usuario") as Usuario
        tv_id.text = "Código: ${usuario.id}"
        tv_nome.text = "Nome: ${usuario.name}"
        tv_email.text = "E-mail: ${usuario.email}"
    }

}
