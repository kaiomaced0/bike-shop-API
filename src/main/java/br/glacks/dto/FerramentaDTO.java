package br.glacks.dto;

import br.glacks.model.Ferramenta;
import br.glacks.model.Produto;

public record FerramentaDTO(
        ProdutoDTO p
) {
    public static Ferramenta criaFerramenta(ProdutoDTO produtoDTO){
        Ferramenta f = new Ferramenta();
        f.setNome(produtoDTO.nome());
        f.setNomeLongo(produtoDTO.nomeLongo());
        f.setPreco(produtoDTO.preco());
        f.setValorCompra(produtoDTO.valorCompra());
        f.setEstoque(produtoDTO.estoque());

        return f;
    }
}
