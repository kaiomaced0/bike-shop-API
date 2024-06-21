package br.glacks.dto;

import jakarta.persistence.Enumerated;

import br.glacks.model.pagamento.BandeiraCartao;
import br.glacks.model.pagamento.Cartao;

public record CartaoResponseDTO(
    Long id,
    String nome,
    String bandeiraCartao,
    Long idUsuario,
    String dataValidade
    
) {
    public CartaoResponseDTO(Cartao cartao){
        this(cartao.getId(), cartao.getNome(),
         cartao.getBandeiraCartao().getLabel(), cartao.getUsuario().getId(), cartao.getDataValidade());
    }
    
}
