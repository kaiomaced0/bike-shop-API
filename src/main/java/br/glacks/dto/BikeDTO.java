package br.glacks.dto;

import jakarta.persistence.Enumerated;
import br.glacks.model.Cor;
import br.glacks.model.bike.Bike;
import br.glacks.model.bike.Tamanho;
import br.glacks.model.bike.TipoBike;

public record BikeDTO(
    String nome,
    String nomeLongo,
    Double preco,
    @Enumerated Cor cor,
    Integer estoque,
    String marca,
    String observacao,
    String marcha,
    @Enumerated Tamanho tamanho,
    @Enumerated TipoBike tipoBike

) {
    public static Bike criaBike(BikeDTO bikeDTO){
        Bike bike = new Bike();
        bike.setNome(bikeDTO.nome());
        bike.setNomeLongo(bikeDTO.nomeLongo());
        bike.setPreco(bikeDTO.preco());
        bike.setCor(bikeDTO.cor());
        bike.setEstoque(bikeDTO.estoque());
        bike.setMarca(bikeDTO.marca);
        bike.setObservacao(bikeDTO.observacao);
        bike.setTamanho(bikeDTO.tamanho);
        bike.setTipoBike(bikeDTO.tipoBike);
        return bike;
    }
    
}
