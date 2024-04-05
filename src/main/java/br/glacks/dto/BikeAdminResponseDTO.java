package br.glacks.dto;

import br.glacks.model.bike.Bike;
import br.glacks.model.bike.Tamanho;
import br.glacks.model.bike.TipoBike;
import jakarta.persistence.Enumerated;

public record BikeAdminResponseDTO(
        ProdutoAdminResponseDTO produto,
        String marcha,
        @Enumerated Tamanho tamanho,
        @Enumerated TipoBike tipoBike

) {
    public BikeAdminResponseDTO(Bike bike){
        this(new ProdutoAdminResponseDTO(bike), bike.getMarcha(), bike.getTamanho(), bike.getTipoBike());
    }

}
