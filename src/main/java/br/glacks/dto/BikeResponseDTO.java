package br.glacks.dto;

import jakarta.persistence.Enumerated;

import br.glacks.model.bike.Bike;
import br.glacks.model.bike.Tamanho;
import br.glacks.model.bike.TipoBike;

import java.util.List;
import java.util.stream.Collectors;

public record BikeResponseDTO(
        ProdutoResponseDTO produto,
        String marcha,
        @Enumerated Tamanho tamanho,
        @Enumerated TipoBike tipoBike

) {
    public BikeResponseDTO(Bike bike){
        this(new ProdutoResponseDTO(bike), bike.getMarcha(), bike.getTamanho(), bike.getTipoBike());
    }

}
