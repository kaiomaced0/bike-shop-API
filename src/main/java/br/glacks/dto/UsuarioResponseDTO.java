package br.glacks.dto;

import br.glacks.model.Usuario;

public class UsuarioResponseDTO {

    private Long id;

    private String nome;

    private String login;


    public UsuarioResponseDTO (Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    
    
}
