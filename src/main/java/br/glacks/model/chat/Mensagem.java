package br.glacks.model.chat;

import javax.persistence.ManyToOne;

import br.glacks.model.EntityClass;
import br.glacks.model.Usuario;

public class Mensagem extends EntityClass{
    
    @ManyToOne
    private Usuario usuario;

    private String dataMensagem;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataMensagem() {
        return dataMensagem;
    }

    public void setDataMensagem(String dataMensagem) {
        this.dataMensagem = dataMensagem;
    }

    


    
}
