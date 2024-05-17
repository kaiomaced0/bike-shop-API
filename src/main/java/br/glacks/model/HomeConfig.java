package br.glacks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity

public class HomeConfig extends EntityClass{

    @OneToMany
    @JoinColumn(name = "lista_destaques")
    private List<Produto> produtosDestaque;
    @OneToMany
    @JoinColumn(name = "lista_carrossel")
    private List<Carrossel> listaCarrosel;

    public List<Produto> getProdutosDestaque() {
        return produtosDestaque;
    }

    public void setProdutosDestaque(List<Produto> produtosDestaque) {
        this.produtosDestaque = produtosDestaque;
    }

    public List<Carrossel> getListaCarrosel() {
        return listaCarrosel;
    }

    public void setListaCarrosel(List<Carrossel> listaCarrosel) {
        this.listaCarrosel = listaCarrosel;
    }
}
