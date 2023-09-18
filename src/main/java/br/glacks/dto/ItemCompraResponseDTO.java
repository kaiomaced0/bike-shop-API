package br.glacks.dto;

import br.glacks.model.ItemCompra;

public record ItemCompraResponseDTO(
    Long produtoId,
    Integer quantidade,
    Double preco
) {
    public ItemCompraResponseDTO(ItemCompra itemCompra){
        this(itemCompra.getProduto().getId(), itemCompra.getQuantidade(), itemCompra.getPreco());
    }
    
    
}
