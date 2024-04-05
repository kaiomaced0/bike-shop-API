package br.glacks.dto;

import br.glacks.model.bike.Pneu;

public record PneuResponseDTO(
        Long id, String nome
) {
    public PneuResponseDTO(Pneu p){
        this(p.getId(), p.getNome());
    }
}
