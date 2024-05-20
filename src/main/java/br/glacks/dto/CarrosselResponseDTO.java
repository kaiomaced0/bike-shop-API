package br.glacks.dto;

import br.glacks.model.Carrossel;

public record CarrosselResponseDTO(
        Long id,
        String link,
        String image,
        String nome
) {
    public CarrosselResponseDTO(Carrossel c){
        this(c.getId(), c.getLink(), c.getImage(), c.getNome());
    }
}
