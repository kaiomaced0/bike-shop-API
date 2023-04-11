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

    private Integer avaliacao;

    private Boolean ver = true;

    
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

    public Boolean getVer() {
        return ver;
    }

    public void setVer(Boolean ver) {
        this.ver = ver;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    


    
}
