package br.glacks.model;

import java.time.LocalDateTime;

import br.glacks.model.locais.Cidade;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Endereco extends EntityClass{

    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "usuario_dono_endereco")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cidade_endereco")
    private Cidade cidade;

    private String cep;

    private String rua;

    private String numero;

    private String descricao;

    private Boolean principal;

    @PrePersist
    private void gerarDataInclusao() {
        principal = false;
    }
    

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}
