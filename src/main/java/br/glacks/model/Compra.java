package br.glacks.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;

import br.glacks.model.pagamento.FormaPagamento;

@Entity
public class Compra extends EntityClass{

    @ManyToOne
    private Usuario usuario;

    @OneToMany
    @JoinColumn(name = "lista_ItemCompra")
    private List<ItemCompra> listaItemCompra;

    private Double valorTotal;

    @Enumerated(EnumType.ORDINAL)    
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.ORDINAL)    
    private StatusPedido statusPedido;

    private String token;

    private String codigoRastreio;

    private String dataPrevista;

    private String dataEntrega;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_compra")
    private Endereco enderecoEntrega;

    @Column(name = "pagamento_realizado")
    private Boolean pago;

    @ManyToOne
    @JoinColumn(name = "cupom_compra")
    private Cupom cupom;

    
    @PrePersist
    public void inserirNome(){
        setNome("#"+ usuario.getId().toString() + getId().toString() );
    }


    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token;
    }


    public String getCodigoRastreio() {
        return codigoRastreio;
    }


    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }


    public String getDataPrevista() {
        return dataPrevista;
    }


    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }


    public String getDataEntrega() {
        return dataEntrega;
    }


    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public List<ItemCompra> getListaItemCompra() {
        return listaItemCompra;
    }


    public void setListaItemCompra(List<ItemCompra> listaItemCompra) {
        this.listaItemCompra = listaItemCompra;
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


    public StatusPedido getStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }


    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }
    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }


    public Boolean getPago() {
        return pago;
    }
    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Cupom getCupom() {
        return cupom;
    }
    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    
    
}
