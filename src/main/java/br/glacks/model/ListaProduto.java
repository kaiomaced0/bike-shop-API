package br.glacks.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ListaProduto extends EntityClass{

    @ManyToOne
    @JoinColumn(name = "produto_lista_produto")
    private Produto produto;

    @Enumerated(EnumType.ORDINAL)
    private TipoListaProduto tipoListaProduto;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "tamanho_lista_produto")
    
    private Tamanho tamanho;

    @ManyToOne
    @JoinColumn(name = "cor_lista_produto")
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

    public TipoListaProduto getTipoListaProduto() {
        return tipoListaProduto;
    }
    public void setTipoListaProduto(TipoListaProduto tipoListaProduto) {
        this.tipoListaProduto = tipoListaProduto;
    }      
    
    
}
