package br.glacks.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateNomeDTO(
    @Size(min = 3, max = 1000)
    @NotBlank
    String senha,
    
    @Size(min = 2, max = 50)
    @NotBlank
    String nome
) {
    
}
