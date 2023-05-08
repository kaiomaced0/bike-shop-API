package br.glacks.dto;

import jakarta.persistence.Enumerated;

import br.glacks.model.Usuario;
import br.glacks.model.pagamento.BandeiraCartao;
import br.glacks.model.pagamento.Cartao;

public record CartaoDTO(
    Long id,
    String nome,
    @Enumerated BandeiraCartao bandeiraCartao,
    String numero,
    Long usuario
) {
    public static Cartao criaCartao(CartaoDTO cartaoDTO){
        Cartao cartao = new Cartao();
        cartao.setId(cartaoDTO.id);
        cartao.setNome(cartaoDTO.nome);
        cartao.setBandeiraCartao(cartaoDTO.bandeiraCartao);
        cartao.setNumero(cartaoDTO.numero);
        Usuario user = new Usuario();
        user.setId(cartaoDTO.usuario);
        return cartao;
    }

    public static Cartao mudaCartao(Cartao cartao, CartaoDTO cartaoDTO){
        cartao.setNome(cartaoDTO.nome);
        cartao.setBandeiraCartao(cartaoDTO.bandeiraCartao);
        cartao.setNumero(cartaoDTO.numero);
        return cartao;
    }
    
}
