package br.glacks.dto;

public record CidadeResponseDTO(
    Long id,
    String nome,
    EstadoResponseDTO estadoResponseDTO
) {
    
}
