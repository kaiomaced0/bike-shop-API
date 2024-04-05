package br.glacks.model.bike;

import br.glacks.model.EntityClass;
import jakarta.persistence.Entity;

@Entity
public class Freio extends EntityClass {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
