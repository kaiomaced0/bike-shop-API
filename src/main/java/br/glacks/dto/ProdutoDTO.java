package br.glacks.dto;

import jakarta.persistence.Enumerated;

import br.glacks.model.Cor;
import br.glacks.model.Produto;

public record ProdutoDTO(
    String nome,
    String nomeLongo,
    Double preco,
    @Enumerated Cor cor,
    Integer estoque
) {
    public static Produto criaProduto(ProdutoDTO produtoDTO){
        Produto p = new Produto();
        p.setNome(produtoDTO.nome);
        p.setNomeLongo(produtoDTO.nomeLongo);
        p.setPreco(produtoDTO.preco);
        p.setCor(produtoDTO.cor);
        p.setEstoque(produtoDTO.estoque);

        return p;
    }
    
}
