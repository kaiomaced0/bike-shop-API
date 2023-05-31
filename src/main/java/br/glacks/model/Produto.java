package br.glacks.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto extends EntityClass {

    private String nomeLongo;

    private Double valorCompra;
    
    @Column(name = "lista_imagem_produto")
    private List<String> image;

    @Enumerated(EnumType.ORDINAL) 
    private Cor cor;

    @OneToMany
    @JoinColumn(name = "lista_avaliacao")
    private List<Avaliacao> avaliacoes;

    private Integer Estoque;

    private Double preco;

    private Boolean visivel;

    @CollectionTable
    @ElementCollection
    @Column(name = "url_imagens_produto")
    private List<String> img;

    private Double estrelas;


    public Boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public Double getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(Double estrelas) {
        this.estrelas = estrelas;
    }

    public String getNomeLongo() {
        return nomeLongo;
    }

    public void setNomeLongo(String nomeLongo) {
        this.nomeLongo = nomeLongo;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Integer getEstoque() {
        return Estoque;
    }

    public void setEstoque(Integer estoque) {
        Estoque = estoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    
}
