package br.glacks.dto;

import br.glacks.model.Carrossel;

public record CarrosselResponseDTO(
        String link,
        String image
) {
    public CarrosselResponseDTO(Carrossel c){
        this(c.getLink(), c.getImage());
    }
}
