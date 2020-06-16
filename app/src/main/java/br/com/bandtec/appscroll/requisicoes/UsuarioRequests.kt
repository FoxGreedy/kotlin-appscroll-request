package br.com.bandtec.appscroll.requisicoes

import br.com.bandtec.appscroll.modelos.Usuario
import feign.RequestLine

interface UsuarioRequests {

    @RequestLine("GET /users")
    fun getUsuarios(): List<Usuario>
}