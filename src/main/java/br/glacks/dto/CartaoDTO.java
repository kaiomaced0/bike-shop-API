package br.glacks.dto;

import javax.persistence.Enumerated;

import br.glacks.model.pagamento.BandeiraCartao;
import br.glacks.model.pagamento.Cartao;

public record CartaoDTO(
    String nome,
    @Enumerated BandeiraCartao bandeiraCartao,
    String numero
) {
    public static Cartao criaCartao(CartaoDTO cartaoDTO){
        Cartao cartao = new Cartao();
        cartao.setNome(cartaoDTO.nome);
        cartao.setBandeiraCartao(cartaoDTO.bandeiraCartao);
        cartao.setNumero(cartaoDTO.numero);
        return cartao;
    }

    public static Cartao mudaCartao(Cartao cartao, CartaoDTO cartaoDTO){
        cartao.setNome(cartaoDTO.nome);
        cartao.setBandeiraCartao(cartaoDTO.bandeiraCartao);
        cartao.setNumero(cartaoDTO.numero);
        return cartao;
    }
    
}
