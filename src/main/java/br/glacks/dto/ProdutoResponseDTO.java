package br.glacks.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.Cor;
import br.glacks.model.Produto;
import jakarta.persistence.Enumerated;

public record ProdutoResponseDTO(
        String nome,
        String nomeLongo,
        Double preco,
        @Enumerated Cor cor,
        Integer estoque,
        List<AvaliacaoResponseDTO> avaliacoes,
        List<String> images) {

    public ProdutoResponseDTO(Produto produto){
        this(produto.getNome(),
         produto.getNomeLongo(),
         produto.getPreco(),
          produto.getCor(),
          produto.getEstoque(),
          produto.getAvaliacoes()
            .stream()
            .map(avaliacao -> new AvaliacaoResponseDTO(avaliacao))
            .collect(Collectors.toList()),
            produto.getImg());
    }

}