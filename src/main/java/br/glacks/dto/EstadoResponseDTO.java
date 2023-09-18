package br.glacks.dto;

import br.glacks.model.locais.Estado;

public record EstadoResponseDTO(
    Long id,
    String nome
) {
    public EstadoResponseDTO (Estado estado){
        this(estado.getId(), estado.getNome());
    }
    
}
