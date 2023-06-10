package br.glacks.dto;

public record UsuarioUpdateDTO(
    String nome,
    String login,
    String senha,
    String email
) {
    
}
