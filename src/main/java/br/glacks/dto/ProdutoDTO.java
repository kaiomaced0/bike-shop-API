package br.glacks.dto;

import jakarta.persistence.Enumerated;

import br.glacks.model.Cor;
import br.glacks.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public record ProdutoDTO(

        @Size(min = 5, max = 60)
    String nome,
        @Size(max = 160)
    String nomeLongo,
    String descricao,

        @Size(min = 1)
    Double valorCompra,

        @Size(min = 1)
    Double preco,
    Long idMarca,
    List<Long> categoriasId,
    Long idCor,
        @Size(min = 1)
    Integer estoque,
    List<String> img
) {
    public static Produto criaProduto(ProdutoDTO produtoDTO){
        Produto p = new Produto();
        p.setNome(produtoDTO.nome);
        p.setNomeLongo(produtoDTO.nomeLongo);
        p.setDescricao(produtoDTO.descricao);
        p.setPreco(produtoDTO.preco);
        p.setValorCompra(produtoDTO.valorCompra);
        p.setEstoque(produtoDTO.estoque);
        p.setImg(new ArrayList<>());
        if(!produtoDTO.img().isEmpty())
            produtoDTO.img().stream().forEach(img -> {
                p.getImg().add(img);
            });

        return p;
    }
    
}
