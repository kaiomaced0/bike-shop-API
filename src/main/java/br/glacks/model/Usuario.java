package br.glacks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Usuario extends EntityClass {

    private String login;

    private String senha;

    private String cpf;
    
    @Column(name ="data_nascimento")
    private String dataNascimento;

    



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
