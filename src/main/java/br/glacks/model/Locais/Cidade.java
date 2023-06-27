package br.glacks.model.locais;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import br.glacks.model.EntityClass;

@Entity
public class Cidade extends EntityClass{

    private String nome;
    
    @ManyToOne
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
}
