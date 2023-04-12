package br.glacks.model.locais;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.glacks.model.EntityClass;

@Entity
public class Cidade extends EntityClass{

    @ManyToOne
    private Estado estado;

    @OneToMany
    @JoinColumn(name = "lista_cep_cidade")
    private List<Cep> ceps;


    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        
    }

    public List<Cep> getCeps() {
        return ceps;
    }

    public void setCeps(List<Cep> ceps) {
        this.ceps = ceps;
    }


    

    
}
