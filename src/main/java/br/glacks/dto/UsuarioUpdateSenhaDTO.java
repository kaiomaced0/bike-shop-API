package br.glacks.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateSenhaDTO(
    @Size(min = 3, max = 1000)
    @NotBlank
    String senhaAnterior,
    
    @Size(min = 3, max = 1000)
    @NotBlank
    String novaSenha

) {
    
}
