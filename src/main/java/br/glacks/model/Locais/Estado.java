package br.glacks.model.locais;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;

import br.glacks.model.EntityClass;

@Entity
public class Estado extends EntityClass{

    private String nome;
    
    @Column(name = "sigla_estado", length = 3)
    @Size(max = 3)
    private String sigla;

    public String getSigla() {
        return sigla.toUpperCase();
    }

    public void setSigla(String sigla) {
        this.sigla = sigla.toUpperCase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
