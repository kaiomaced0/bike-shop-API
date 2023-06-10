package br.glacks.dto;

import jakarta.validation.constraints.NotBlank;

public record TelefoneDTO(
    @NotBlank
    String codigoArea,
    @NotBlank
    String numero,
    Integer proprietarioId
) {
    
}
