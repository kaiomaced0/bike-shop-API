package br.glacks.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateDTO(
    @Size(min = 2, max = 50)
    String nome,
    @Size(min = 3, max = 25)
    String login,
    @Size(min = 3, max = 1000)
    String senha,
    @Email
    String email
) {
    
}
