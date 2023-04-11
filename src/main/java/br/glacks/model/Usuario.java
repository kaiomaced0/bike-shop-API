package br.glacks.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import br.glacks.model.pagamento.Cartao;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends EntityClass {

    private String login;

    private String senha;

    @OneToOne
    private Carrinho carrinho;
    
    @Column(name = "valor_gasto")
    private Double valorGasto;

    @OneToMany
    @JoinColumn(name = "lista_pedidos_usuario")
    private List<Pedido> pedidos;

    @OneToMany
    @JoinColumn(name = "lista_enderecos_usuario")
    private List<Endereco> enderecos;

    @OneToMany
    @JoinColumn(name = "lista_cartoes_usuario")
    private List<Cartao> cartoes;

    @OneToMany
    @JoinColumn(name = "lista_gostei_usuario")
    private List<Produto> gostei;

    @OneToMany
    @JoinColumn(name = "lista_telefones_usuario")
    private List<Telefone> telefones;



    @PrePersist
    public void criaCarrinho(){
        carrinho.setUsuario(this);
    }
    
    public Carrinho getCarrinho() {
        return carrinho;
    }


    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }


    public List<Telefone> getTelefones() {
        return telefones;
    }


    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }


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
