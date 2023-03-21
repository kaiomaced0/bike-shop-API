package br.glacks.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ListaProduto extends EntityClass{

    @ManyToOne
    private Produto produto;
    private Integer quantidade;
    private String tamanho;
    private String cor;

    
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }      
    
    
}
