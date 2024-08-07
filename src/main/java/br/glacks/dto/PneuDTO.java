package br.glacks.dto;

import br.glacks.model.bike.Pneu;

public record PneuDTO(
        ProdutoDTO p
) {
    public static Pneu criaPneu(ProdutoDTO produtoDTO){
        Pneu f = new Pneu();
        f.setNome(produtoDTO.nome());
        f.setNomeLongo(produtoDTO.nomeLongo());
        f.setPreco(produtoDTO.valorCompra());
        f.setValorCompra(produtoDTO.preco());
        f.setEstoque(produtoDTO.estoque());
        return f;
    }
}
