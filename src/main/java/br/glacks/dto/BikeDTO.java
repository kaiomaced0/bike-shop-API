package br.glacks.dto;

import javax.persistence.Enumerated;

import br.glacks.model.bike.Bike;
import br.glacks.model.bike.Tamanho;
import br.glacks.model.bike.TipoBike;

public record BikeDTO(
    ProdutoDTO produtoDTO,
    String marca,
    String observacao,
    String marcha,
    @Enumerated Tamanho tamanho,
    @Enumerated TipoBike tipoBike

) {
    public static Bike criaBike(BikeDTO bikeDTO){
        Bike bike = new Bike();
        bike.setNome(bikeDTO.produtoDTO.nome());
        bike.setNomeLongo(bikeDTO.produtoDTO.nomeLongo());
        bike.setPreco(bikeDTO.produtoDTO.preco());
        bike.setCor(bikeDTO.produtoDTO.cor());
        bike.setEstoque(bikeDTO.produtoDTO.estoque());
        bike.setMarca(bikeDTO.marca);
        bike.setObservacao(bikeDTO.observacao);
        bike.setTamanho(bikeDTO.tamanho);
        bike.setTipoBike(bikeDTO.tipoBike);
        return bike;
    }
    
}
