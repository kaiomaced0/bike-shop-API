package br.glacks.dto;

import br.glacks.model.Avaliacao;
import br.glacks.model.Produto;
import br.glacks.model.Usuario;

public record AvaliacaoDTO(
    long id,
    Integer estrela,
    String comentario,
    Long usuario,
    Long produto

) {
    public static Avaliacao criAvaliacao(AvaliacaoDTO avaliacaoDTO){
        Avaliacao a = new Avaliacao();
        a.setId(avaliacaoDTO.id);
        a.setEstrela(avaliacaoDTO.estrela);
        a.setComentario(avaliacaoDTO.comentario);
        Usuario user = new Usuario();
        user.setId(avaliacaoDTO.usuario);
        a.setUsuario(user);
        Produto prod = new Produto();
        prod.setId(avaliacaoDTO.produto);
        a.setProduto(prod);
        return a;
    }
    
}
