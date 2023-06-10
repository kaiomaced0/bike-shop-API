package br.glacks.dto;

public record ItemCompraDTO(
    Long produtoId,
    Integer quantidade,
    Double preco
) {
    
}
