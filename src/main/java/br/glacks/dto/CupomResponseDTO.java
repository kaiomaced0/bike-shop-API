package br.glacks.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.Cupom;


public record CupomResponseDTO(
        Long id,
    
    String nome,
    Integer quantidade,
    String codigo,
    Double valorDesconto,
    List<ProdutoResponseDTO> produtos
    
) {
    public CupomResponseDTO(Cupom cupom){
        this(cupom.getId(), cupom.getNome(),
            cupom.getQuantidade(),
            cupom.getCodigo(),
            cupom.getValorDesconto(),
            cupom.getProdutos().stream()
                    .map(ProdutoResponseDTO::new)
                    .collect(Collectors.toList()));
    }
    
}
