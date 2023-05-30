package br.glacks.dto;

import br.glacks.model.Usuario;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String login,
    String email

){
    public UsuarioResponseDTO(Usuario user){
        this(user.getId(),
        user.getNome(),
        user.getLogin(),
        user.getEmail());

    }
}
