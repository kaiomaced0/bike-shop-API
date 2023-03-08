package br.glacks.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Estoque extends EntityClass{

    @OneToOne(cascade = CascadeType.ALL)
    private ListaProduto produtoEstoque;

    @ManyToOne
    private Produto produto = produtoEstoque.getProduto();

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
