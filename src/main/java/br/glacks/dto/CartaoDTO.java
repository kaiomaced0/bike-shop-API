package br.glacks.dto;

import jakarta.persistence.Enumerated;

import br.glacks.model.Usuario;
import br.glacks.model.pagamento.BandeiraCartao;
import br.glacks.model.pagamento.Cartao;

public record CartaoDTO(
    String nome,
    int bandeiraCartaoId,
    String numero,
    String dataValidade
) {
    public static Cartao criaCartao(CartaoDTO cartaoDTO){
        Cartao cartao = new Cartao();
        cartao.setNome(cartaoDTO.nome);
        cartao.setBandeiraCartao(BandeiraCartao.valueOf(cartaoDTO.bandeiraCartaoId));
        cartao.setNumero(cartaoDTO.numero);
        cartao.setDataValidade(cartaoDTO.dataValidade);
        return cartao;
    }

    public static Cartao mudaCartao(Cartao cartao, CartaoDTO cartaoDTO){
        cartao.setNome(cartaoDTO.nome);
        cartao.setBandeiraCartao(BandeiraCartao.valueOf(cartaoDTO.bandeiraCartaoId));
        cartao.setNumero(cartaoDTO.numero);
        return cartao;
    }
    
}
