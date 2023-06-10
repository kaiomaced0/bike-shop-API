package br.glacks.dto;

import jakarta.persistence.Enumerated;

import br.glacks.model.Usuario;
import br.glacks.model.pagamento.BandeiraCartao;
import br.glacks.model.pagamento.Cartao;

public record CartaoDTO(
    Integer id,
    String nome,
    @Enumerated BandeiraCartao bandeiraCartao,
    String numero,
    Integer usuario
) {
    public static Cartao criaCartao(CartaoDTO cartaoDTO){
        Cartao cartao = new Cartao();
        cartao.setId(cartaoDTO.id.longValue());
        cartao.setNome(cartaoDTO.nome);
        cartao.setBandeiraCartao(cartaoDTO.bandeiraCartao);
        cartao.setNumero(cartaoDTO.numero);
        Usuario user = new Usuario();
        user.setId(cartaoDTO.usuario.longValue());
        return cartao;
    }

    public static Cartao mudaCartao(Cartao cartao, CartaoDTO cartaoDTO){
        cartao.setNome(cartaoDTO.nome);
        cartao.setBandeiraCartao(cartaoDTO.bandeiraCartao);
        cartao.setNumero(cartaoDTO.numero);
        return cartao;
    }
    
}
