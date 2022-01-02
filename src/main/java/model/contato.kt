package main.java.model

import main.java.entity.contato
import java.lang.Exception

class contato {

    companion object {
        private val listaDeContatos = mutableListOf<contato>()

        fun salvarContato(contato: contato) {
            listaDeContatos.add(contato)
        }

        fun deletarContato(contato: contato) {

            for (item in listaDeContatos.withIndex()){
                if(item.value.nome == contato.nome && item.value.telefone == contato.telefone){
                    listaDeContatos.removeAt(item.index);
                    break;
                }
            }

        }
        fun retornaContatos(): List<contato>{
            return listaDeContatos
        }
    }


}