package br.glacks.dto;

import br.glacks.model.Marca;

public record MarcaResponseDTO(
        Long id,
        String nome
) {
    public MarcaResponseDTO(Marca m){
        this(m.getId(),m.getNome());
    }
}
