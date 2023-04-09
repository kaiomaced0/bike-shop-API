package br.glacks.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.glacks.model.pagamento.Cartao;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends EntityClass {


    private String login;

    private String senha;

    @Column(name = "valor_gasto")
    private Double valorGasto;

    @OneToMany
    @JoinColumn(name = "lista_pedidos")
    private List<Pedido> pedidos;

    @OneToMany
    @JoinColumn(name = "lista_enderecos")
    private List<Endereco> enderecos;

    @OneToMany
    @JoinColumn(name = "lista_cartoes")
    private List<Cartao> cartoes;

    @OneToMany
    @JoinColumn(name = "lista_gostei")
    private List<Produto> gostei;

    @OneToMany
    @JoinColumn(name = "lista_telefones")
    private List<Telefone> telefones;



    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public List<Produto> getGostei() {
        return gostei;
    }

    public void setGostei(List<Produto> gostei) {
        this.gostei = gostei;
    }

    public Double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(Double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
