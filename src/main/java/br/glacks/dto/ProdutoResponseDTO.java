package br.glacks.dto;

import jakarta.persistence.Enumerated;

import java.util.List;

import br.glacks.model.Avaliacao;
import br.glacks.model.Cor;
import br.glacks.model.Produto;

public record ProdutoResponseDTO(
    String nome,
    String nomeLongo,
    Double preco,
    @Enumerated Cor cor,
    Integer estoque,
    List<Avaliacao> avaliacoes
) {
    public ProdutoResponseDTO(Produto produto){
        this(produto.getNome(), produto.getNomeLongo(),
         produto.getPreco(), produto.getCor(), produto.getEstoque(), produto.getAvaliacoes());
    }

    
}
