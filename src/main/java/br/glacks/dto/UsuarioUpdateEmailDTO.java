package br.glacks.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateEmailDTO(
    @Size(min = 3, max = 1000)
    @NotBlank
    String senha,
    @Email
    @NotBlank
    String email
) {
    
}
