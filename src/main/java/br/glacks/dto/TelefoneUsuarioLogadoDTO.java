package br.glacks.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TelefoneUsuarioLogadoDTO(
    @NotBlank(message = "O campo 'codigoArea' deve ser preenchido")
    @Size(max = 2)
    String codigoArea,
    @NotBlank(message = "O campo 'numero' deve ser preenchido")
    @Size(max = 10)
    String numero
) {
    
}
