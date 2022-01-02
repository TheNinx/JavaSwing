package main.java.controller

import main.java.entity.contato
import java.lang.Exception

class contato {

    fun getContador(): String {
        val list = listaContatos()
        return when{
            list.isEmpty() -> "0 CONTATOS"
            list.size == 1  -> "1 CONTATOS"
            else -> "${list.size} contatos"
        }
    }


    private fun validate(nome: String, telefone: String) {
        if (nome == "") {
            throw Exception("O nome nao pode estar em branco")
        }
        if (telefone == "") {
            throw Exception("O telefone nao pode estar em branco")
        }
    }

    fun salvarContato(nome: String, telefone: String) {
        validate(nome, telefone)
        val contato = contato(nome, telefone)
        main.java.model.contato.salvarContato(contato);


    }

    private fun validarDeletar(nome: String, telefone: String) {
        if (nome == "" || telefone == "") {
            throw Exception("Escolha um contato para remover")
        }
    }

    fun deletarContato(nome: String, telefone: String) {

        validarDeletar(nome,telefone)
         val contatoDeletar = main.java.entity.contato(nome, telefone)
        main.java.model.contato.deletarContato(contatoDeletar)

    }

    fun listaContatos(): List<contato> {
        return main.java.model.contato.retornaContatos()
    }
}