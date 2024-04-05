package br.glacks.dto;

import java.util.List;

import br.glacks.model.Cupom;
import br.glacks.model.Produto;

public record CupomDTO(
    String nome,
    Integer quantidade,
    String codigo,
    Double valorDesconto,
    List<Long> idProdutos
) {
    public static Cupom criaCupom(CupomDTO cupomDTO){
        Cupom cupom = new Cupom();
        cupom.setNome(cupomDTO.nome);
        cupom.setQuantidade(cupomDTO.quantidade);
        cupom.setCodigo(cupomDTO.codigo);
        cupom.setValorDesconto(cupomDTO.valorDesconto);
        return cupom;
    }
    
}
