package br.glacks.model.chat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import br.glacks.model.EntityClass;
import br.glacks.model.Usuario;
@Entity
public class Mensagem extends EntityClass{
    
    @ManyToOne
    private Usuario usuario;

    private String dataMensagem;

    private Boolean ver;

    
    @PrePersist
    public void inserirNome(){
        setNome("#"+ getUsuario().getId().toString() + getId().toString());
    }

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

    public Boolean getVer() {
        return ver;
    }

    public void setVer(Boolean ver) {
        this.ver = ver;
    }

    


    
}
