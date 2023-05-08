package br.glacks.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Usuario{

    @Size(min = 14, max =14)
    private String cnpj;
    
    @ManyToMany
    @JoinColumn(name = "usuarios_responsaveis_pj")
    private List<PessoaFisica> usuariosResponsaveis;

    private String nomeFantasia;
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<PessoaFisica> getUsuariosResponsaveis() {
        return usuariosResponsaveis;
    }

    public void setUsuariosResponsaveis(List<PessoaFisica> usuariosResponsaveis) {
        this.usuariosResponsaveis = usuariosResponsaveis;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    


    
}
