package br.glacks.dto;

import javax.persistence.Enumerated;

import br.glacks.model.pagamento.BandeiraCartao;
import br.glacks.model.pagamento.Cartao;

public record CartaoResponseDTO(
    Long id,
    String nome,
    @Enumerated BandeiraCartao bandeiraCartao,
    UsuarioResponseDTO usuarioResponseDTO
    
) {
    public CartaoResponseDTO(Cartao cartao){
        this(cartao.getId(), cartao.getNome(),
         cartao.getBandeiraCartao(), new UsuarioResponseDTO(cartao.getUsuario()));
    }
    
}
