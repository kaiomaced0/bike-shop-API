package br.glacks.dto;

import br.glacks.model.Produto;

import java.util.List;
import java.util.stream.Collectors;

public record ProdutoAdminResponseDTO(
        Long id,
        String nome,
        String nomeLongo,
        String descricao,
        Double valorCompra,
        Double preco,
        String cor,
        Integer estoque,
        Double estrelas,
        List<AvaliacaoResponseDTO> avaliacoes,
        List<CategoriaResponseDTO> categorias,
        List<String> img,
        MarcaResponseDTO marca) {

    public ProdutoAdminResponseDTO(Produto produto){
        this(produto.getId(), produto.getNome(),
         produto.getNomeLongo(),
         produto.getDescricao(),
                produto.getValorCompra(),
         produto.getPreco(),
          produto.getCor().getLabel(),
          produto.getEstoque(),
                produto.getEstrelas(),
          produto.getAvaliacoes() != null ? produto.getAvaliacoes()
            .stream()
            .map(AvaliacaoResponseDTO::new)
            .collect(Collectors.toList()): null,
                produto.getCategorias() != null ? produto.getCategorias()
                        .stream()
                        .map(CategoriaResponseDTO::new)
                        .collect(Collectors.toList()): null,
            produto.getImg(), new MarcaResponseDTO(produto.getMarca()));
    }

}