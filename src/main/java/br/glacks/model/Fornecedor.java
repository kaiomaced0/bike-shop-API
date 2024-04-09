package br.glacks.model;

import jakarta.persistence.Entity;

@Entity
public class Fornecedor extends EntityClass{

    private String nome;

    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
