package br.glacks.dto;

import br.glacks.model.Usuario;

public class UsuarioResponseDTO {

    private Long id;

    private String nome;

    public UsuarioResponseDTO (Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
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
