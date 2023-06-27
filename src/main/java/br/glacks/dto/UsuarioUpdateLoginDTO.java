package br.glacks.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateLoginDTO(
    @Size(min = 3, max = 1000)
    @NotBlank
    String senha,
    @Size(min = 3, max = 25)
    @NotBlank
    String login
) {
    
}
