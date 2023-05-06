package br.glacks.dto;

import br.glacks.model.Avaliacao;

public record AvaliacaoResponseDTO(
    long id,
    Integer estrela,
    String comentario,
    UsuarioResponseDTO usuario,
    ProdutoResponseDTO produto
) {

    public AvaliacaoResponseDTO (Avaliacao avaliacao){
        this(avaliacao.getId(),  avaliacao.getEstrela(), 
        avaliacao.getComentario(), new UsuarioResponseDTO(avaliacao.getUsuario()), new ProdutoResponseDTO(avaliacao.getProduto())); 

    }
   
}
