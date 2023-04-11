package br.glacks.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import br.glacks.model.chat.Mensagem;

@Entity
public class Pedido extends EntityClass {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Compra compra;

    @Column(name = "status_entrega_pedido")
    private String status;

    private Double estrelas;

    private String dataEntrega;
    
    @OneToMany
    private List<Mensagem> avaliacao;

    @PrePersist
    public void inserirNome(){
        if(getNome() == null)
            setNome("#"+ getId().toString() + compra.getNome());

        for (ListaProduto lista : compra.getCarrinho().getlistaProdutos()) {
            lista.setTipoListaProduto(TipoListaProduto.PEDIDO);
        }
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(Double estrelas) {
        this.estrelas = estrelas;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public List<Mensagem> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Mensagem> avaliacao) {
        this.avaliacao = avaliacao;
    }

        
}
