package br.glacks.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto extends EntityClass {

    private String nome;

    private String nomeLongo;

    private Double valorCompra;

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

    @ManyToMany
    @JoinColumn(name = "lista_categoria")
    private List<Categoria> categorias;


    @ManyToOne
    @JoinColumn(name = "fornecedor")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "marca")
    private Marca marca;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    
}
