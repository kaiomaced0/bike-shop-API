package br.glacks.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Categoria extends EntityClass{
    
    @ManyToMany
    @JoinColumn(name = "produtos_categoria")
    private List<Produto> produtos;

    @OneToMany
    @JoinColumn(name = "lista_categorias_filha_categoria")
    private List<Categoria> categoriasFilha;


    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Categoria> getCategoriasFilha() {
        return categoriasFilha;
    }

    public void setCategoriasFilha(List<Categoria> categoriasFilha) {
        this.categoriasFilha = categoriasFilha;
    }
   

    
}
