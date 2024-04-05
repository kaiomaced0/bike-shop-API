package br.glacks.dto;

import br.glacks.model.Produto;

import java.util.List;
import java.util.stream.Collectors;

public record ProdutoAdminResponseDTO(
        String nome,
        String nomeLongo,
        String descricao,
        Double preco,
        Double valorCusto,
        String cor,
        Integer estoque,
        List<AvaliacaoResponseDTO> avaliacoes,
        List<String> images,
        MarcaResponseDTO marca) {

    public ProdutoAdminResponseDTO(Produto produto){
        this(produto.getNome(),
         produto.getNomeLongo(),
         produto.getDescricao(),
         produto.getPreco(),
                produto.getValorCompra(),
          produto.getCor().getLabel(),
          produto.getEstoque(),
          produto.getAvaliacoes()
            .stream()
            .map(AvaliacaoResponseDTO::new)
            .collect(Collectors.toList()),
            produto.getImg(), new MarcaResponseDTO(produto.getMarca()));
    }

}