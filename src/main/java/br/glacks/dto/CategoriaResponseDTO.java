package br.glacks.dto;

import br.glacks.model.Categoria;

public record CategoriaResponseDTO(
        Long id,
        String nome
) {
    public CategoriaResponseDTO(Categoria c){
        this(c.getId(), c.getNome());
    }
}
