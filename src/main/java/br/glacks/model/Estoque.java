package br.glacks.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class Estoque extends EntityClass{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private ListaProduto produtoEstoque;

    @PrePersist
    public void inserirNome(){
        setNome("#"+ produtoEstoque.getProduto().getId() + getId().toString() );
    }
    
    public ListaProduto getProdutoEstoque() {
        return produtoEstoque;
    }

    public void setProdutoEstoque(ListaProduto produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }

}
