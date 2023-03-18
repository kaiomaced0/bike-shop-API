package br.glacks.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria extends EntityClass{
    
    @ManyToMany
    @JoinColumn(name = "lista_produtos_Categoria")
    private List<Produto> produtos;

    @OneToMany
    @JoinColumn(name = "filha_categorias")
    private List<Categoria> categoriasFilha;

    @ManyToOne
    @JoinColumn(name = "pai_categorias")
    private List<Categoria> categoriasPai;

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

    public List<Categoria> getCategoriasPai() {
        return categoriasPai;
    }

    public void setCategoriasPai(List<Categoria> categoriasPai) {
        this.categoriasPai = categoriasPai;
    }

    
}
