package br.glacks.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import br.glacks.model.pagamento.Cartao;
@Entity
public class Usuario extends EntityClass {

    private String sobrenome;

    private String login;

    private String senha;

    @Size(min = 11, max = 18)
    private String cpf;
    
    @Column(name ="data_nascimento")
    private String dataNascimento;

    @Column(name = "valor_gasto")
    private Double valorGasto;

    @OneToMany
    @Column(name = "lista_pedidos")
    private List<Pedido> pedidos;

    @OneToMany
    @Column(name = "lista_enderecos")
    private List<Endereco> enderecos;

    @OneToMany
    @Column(name = "lista_cartoes")
    private List<Cartao> cartoes;

    @OneToMany
    @Column(name = "lista_gostei")
    private List<Produto> gostei;


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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    
}
