package br.glacks.dto;

import javax.persistence.Enumerated;

import br.glacks.model.bike.Bike;
import br.glacks.model.bike.Tamanho;
import br.glacks.model.bike.TipoBike;

public record BikeResponseDTO(
    ProdutoResponseDTO produtoResponseDTO,
    String marca,
    String observacao,
    String marcha,
    @Enumerated Tamanho tamanho,
    @Enumerated TipoBike tipoBike

) {
    public BikeResponseDTO(Bike bike){
        this(new ProdutoResponseDTO(bike), bike.getMarca(), bike.getObservacao(), bike.getMarca(), bike.getTamanho(), bike.getTipoBike());
    }
    
}
