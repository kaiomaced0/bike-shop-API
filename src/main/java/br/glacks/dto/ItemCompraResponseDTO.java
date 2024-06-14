package br.glacks.dto;

import br.glacks.model.ItemCompra;

public record ItemCompraResponseDTO(
    Long produtoId,
    Integer quantidade,
    Double preco,
    String produtoNome,
    String imgProduto,
    Double precoUnitario
) {
    public ItemCompraResponseDTO(ItemCompra itemCompra){
        this(itemCompra.getProduto().getId(), itemCompra.getQuantidade(), itemCompra.getPreco(), itemCompra.getProduto().getNome(), itemCompra.getProduto().getImg().get(0), itemCompra.getProduto().getPreco());
    }
    
    
}
