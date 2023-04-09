package br.glacks.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ListaProduto extends EntityClass{

    @ManyToOne
    private Produto produto;
    private Integer quantidade;
    private Tamanho tamanho;
    private Cor cor;

    
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Tamanho getTamanho() {
        return tamanho;
    }
    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
    public Cor getCor() {
        return cor;
    }
    public void setCor(Cor cor) {
        this.cor = cor;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }      
    
    
}
