package br.glacks.model;

import jakarta.persistence.Entity;

@Entity
public class Fornecedor extends EntityClass{

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
