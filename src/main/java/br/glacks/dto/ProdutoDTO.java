package br.glacks.dto;

import jakarta.persistence.Enumerated;

import br.glacks.model.Cor;
import br.glacks.model.Produto;

import java.util.ArrayList;
import java.util.List;

public record ProdutoDTO(

    String nome,
    String nomeLongo,
    String descricao,
    Double precoCusto,
    Double precoVenda,
    Long idMarca,
    Long idCor,
    Integer estoque,
    List<String> img
) {
    public static Produto criaProduto(ProdutoDTO produtoDTO){
        Produto p = new Produto();
        p.setNome(produtoDTO.nome);
        p.setNomeLongo(produtoDTO.nomeLongo);
        p.setPreco(produtoDTO.precoVenda);
        p.setValorCompra(produtoDTO.precoCusto);
        p.setEstoque(produtoDTO.estoque);
        p.setImg(new ArrayList<>());
        if(!produtoDTO.img().isEmpty())
            produtoDTO.img().stream().forEach(img -> {
                p.getImg().add(img);
            });

        return p;
    }
    
}
