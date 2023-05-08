package br.glacks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Avaliacao extends EntityClass {

    @Column(name = "estrelas")
    private Integer estrela;

    private String comentario;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Produto produto;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getEstrela() {
        return estrela;
    }

    public void setEstrela(Integer estrela) {
        this.estrela = estrela;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
