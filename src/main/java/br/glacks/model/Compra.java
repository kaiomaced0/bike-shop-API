package br.glacks.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.glacks.model.pagamento.FormaPagamento;

@Entity
public class Compra extends EntityClass{

    @ManyToOne
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Carrinho carrinho;

    private Double valorTotal;

    @Enumerated(EnumType.ORDINAL)    
    private FormaPagamento formaPagamento;

    @JoinColumn(name = "endereco_entrega")
    @ManyToOne
    private Endereco enderecoEntrega;

    @Column(name = "pagamento_realizado")
    private Boolean pagamentoRealizado;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Boolean getPagamentoRealizado() {
        return pagamentoRealizado;
    }

    public void setPagamentoRealizado(Boolean pagamentoRealizado) {
        this.pagamentoRealizado = pagamentoRealizado;
    }

    

    
}
