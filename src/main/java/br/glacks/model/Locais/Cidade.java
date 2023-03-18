package br.glacks.model.Locais;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.glacks.model.EntityClass;

@Entity
public class Cidade extends EntityClass{

    @ManyToOne
    private Estado estado;

    @OneToMany
    @Column(name = "lista_cep_cidade")
    private List<Cep> ceps;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    

    
}
