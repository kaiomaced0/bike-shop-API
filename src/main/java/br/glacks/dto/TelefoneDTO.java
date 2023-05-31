package br.glacks.dto;

public record TelefoneDTO(
    String codigoArea,
    String numero,
    Integer proprietarioId
) {
    
}
