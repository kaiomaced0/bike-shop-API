package br.glacks.dto;

public record ItemCompraResponseDTO(
    Long produtoId,
    Integer quantidade,
    Double preco
) {
    
    
}
