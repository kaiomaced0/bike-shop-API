package br.glacks.dto;

import br.glacks.model.Avaliacao;
import br.glacks.model.Produto;
import br.glacks.model.Usuario;

public record AvaliacaoDTO(
    Integer id,
    Integer estrela,
    String comentario,
    Integer produto

) {
    public static Avaliacao criAvaliacao(AvaliacaoDTO avaliacaoDTO){
        Avaliacao a = new Avaliacao();
        a.setId(avaliacaoDTO.id.longValue());
        a.setEstrela(avaliacaoDTO.estrela);
        a.setComentario(avaliacaoDTO.comentario);
        Produto prod = new Produto();
        prod.setId(avaliacaoDTO.produto.longValue());
        a.setProduto(prod);
        return a;
    }
    
}
