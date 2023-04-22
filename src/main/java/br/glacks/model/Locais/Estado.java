package br.glacks.model.locais;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import br.glacks.model.EntityClass;

@Entity
public class Estado extends EntityClass{

    @Column(name = "sigla_estado", length = 3)
    @Size(max = 3)
    private String sigla;

    public String getSigla() {
        return sigla.toUpperCase();
    }

    public void setSigla(String sigla) {
        this.sigla = sigla.toUpperCase();
    }

    
}
