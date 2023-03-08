package br.glacks.model;

import javax.persistence.ManyToOne;

public class ListaProduto{

    @ManyToOne
    private Produto produto;
    private Integer quantidade;

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }      
    
}
