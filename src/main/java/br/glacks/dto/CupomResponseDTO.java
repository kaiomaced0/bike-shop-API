package br.glacks.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.Cupom;


public record CupomResponseDTO(
    
    String nome,
    Integer quantidade,
    String codigo,
    Double valorDesconto,
    List<ProdutoResponseDTO> produtos
    
) {
    public CupomResponseDTO(Cupom cupom){
        this(cupom.getNome(),
            cupom.getQuantidade(),
            cupom.getCodigo(),
            cupom.getValorDesconto(),
            cupom.getProdutos().stream()
                    .map(produto -> new ProdutoResponseDTO(produto))
                    .collect(Collectors.toList()));
    }
    
}
