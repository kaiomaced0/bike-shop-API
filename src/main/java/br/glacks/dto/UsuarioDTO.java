package br.glacks.dto;

import br.glacks.model.Usuario;

public class UsuarioDTO {

    private String nome;
    private String login;
    private String senha;
    private String cpf;

    public UsuarioDTO (Usuario usuario){

        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    
}
