package br.glacks.model.locais;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.glacks.model.EntityClass;

@Entity
public class Cidade extends EntityClass{

    @ManyToOne
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        
    }
  
}
