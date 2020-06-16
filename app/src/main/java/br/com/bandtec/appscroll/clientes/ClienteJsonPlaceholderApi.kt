package br.com.bandtec.appscroll.clientes

import br.com.bandtec.appscroll.requisicoes.UsuarioRequests
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder

object ClienteJsonPlaceholderApi {

    fun criarClienteUsuarios():UsuarioRequests {
        return Feign.builder().decoder(GsonDecoder()).encoder(GsonEncoder())
                .target(UsuarioRequests::class.java, "https://jsonplaceholder.typicode.com")
    }
}