package br.glacks.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import br.glacks.model.pagamento.Cartao;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends EntityClass {

    private String login;

    private String senha;

    private String email;

    private String image;

    
    @ElementCollection
    @CollectionTable(name = "usuario_perfil",
     joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    @Column(name = "perfil", length = 30)
    private Set<Perfil> perfis;

    @OneToMany
    @JoinColumn(name = "lista_enderecos_usuario")
    private List<Endereco> enderecos;

    @OneToMany
    @JoinColumn(name = "lista_cartoes_usuario")
    private List<Cartao> cartoes;

    @OneToMany
    @JoinColumn(name = "lista_desejos")
    private List<Produto> gostei;

    @OneToMany
    @JoinColumn(name = "lista_telefones_usuario")
    private List<Telefone> telefones;

    @OneToMany
    @JoinColumn(name = "lista_compra_usuario")
    private List<Compra> compras;

    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

        
}
