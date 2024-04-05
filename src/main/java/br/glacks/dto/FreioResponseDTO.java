package br.glacks.dto;

import br.glacks.model.bike.Freio;

public record FreioResponseDTO(
        Long id, String nome
) {
    public FreioResponseDTO(Freio f){
        this(f.getId(), f.getNome());
    }
}
