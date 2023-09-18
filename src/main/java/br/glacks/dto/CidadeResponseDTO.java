package br.glacks.dto;

import br.glacks.model.locais.Cidade;

public record CidadeResponseDTO(
    Long id,
    String nome,
    EstadoResponseDTO estadoResponseDTO
) {
    public CidadeResponseDTO(Cidade cidade){
        this(cidade.getId(), cidade.getNome(), new EstadoResponseDTO(cidade.getEstado()));
    }
    
}
