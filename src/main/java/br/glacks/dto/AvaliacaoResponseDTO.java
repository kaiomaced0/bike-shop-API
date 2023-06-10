package br.glacks.dto;

import br.glacks.model.Avaliacao;

public record AvaliacaoResponseDTO(
    long id,
    Integer estrela,
    String comentario,
    Long usuarioId,
    Long produtoId
) {

    public AvaliacaoResponseDTO (Avaliacao avaliacao){
        this(avaliacao.getId(),  avaliacao.getEstrela(), 
        avaliacao.getComentario(), avaliacao.getUsuario().getId(), avaliacao.getProduto().getId()); 

    }
   
}
