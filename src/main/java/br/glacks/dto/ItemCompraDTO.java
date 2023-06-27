package br.glacks.dto;

import br.glacks.model.ItemCompra;
import br.glacks.service.impl.ProdutoServiceImpl;
import jakarta.validation.constraints.NotBlank;

public record ItemCompraDTO(
        @NotBlank Long produtoId,
        @NotBlank Integer quantidade) {

    public static ItemCompra criaItemCompra(ItemCompraDTO itemCompraDTO) {
        try {

            ItemCompra i = new ItemCompra();
            ProdutoServiceImpl p = new ProdutoServiceImpl();

            i.setProduto(p.getId(itemCompraDTO.produtoId));
            if (i.getProduto() == null) {
                throw new Exception();
            }
            i.setQuantidade(itemCompraDTO.quantidade);
            i.setPreco(i.getProduto().getPreco() * itemCompraDTO.quantidade);

            return i;
        } catch (Exception e) {
            return null;
        }

    }

}
