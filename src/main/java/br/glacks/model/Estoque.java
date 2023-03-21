package br.glacks.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Estoque extends EntityClass{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private ListaProduto produtoEstoque;

    @ManyToOne
    private Produto produto;

    public ListaProduto getProdutoEstoque() {
        return produtoEstoque;
    }

    public void setProdutoEstoque(ListaProduto produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    



    
    
    
}
