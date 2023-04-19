package br.glacks.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

import br.glacks.model.chat.Mensagem;

@Entity
public class Produto extends EntityClass {

    private String nomeLongo;

    private Double valorCompra;

    private Double valorVenda;

    @ManyToMany
    @JoinColumn(name = "lista_tamanhos_produto")
    private List<Tamanho> tamanhos;

    @ManyToMany
    @JoinColumn(name = "lista_cores_produto")
    private List<Cor> cores;

    @ManyToMany
    @JoinColumn(name = "lista_categorias_produto")
    private List<Categoria> categorias;

    private Integer Estoque;

    // quando o pedido for realizado o estoque do produto deve diminuir e a
    // quantidade de vendas aumentar.
    private Integer quantidadeVendida;

    private Boolean visivel;

    @CollectionTable
    @ElementCollection
    @Column(name = "url_imagens_produto")
    private List<String> img;

    private Double estrelas;


    
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

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public List<Tamanho> getTamanhos() {
        return tamanhos;
    }

    public void setTamanhos(List<Tamanho> tamanhos) {
        this.tamanhos = tamanhos;
    }

    public List<Cor> getCores() {
        return cores;
    }

    public void setCores(List<Cor> cores) {
        this.cores = cores;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Estoque> getListaEstoque() {
        return listaEstoque;
    }

    public void setListaEstoque(List<Estoque> listaEstoque) {
        this.listaEstoque = listaEstoque;
    }

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
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

}
