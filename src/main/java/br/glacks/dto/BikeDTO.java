package br.glacks.dto;
import br.glacks.model.Produto;
import br.glacks.model.bike.Bike;
import jakarta.persistence.Enumerated;
import br.glacks.model.Cor;
import br.glacks.model.bike.Tamanho;
import br.glacks.model.bike.TipoBike;

import java.util.ArrayList;

public record BikeDTO(
        ProdutoDTO produto,
        String marcha,
        Long idTamanho,
        Long idTipoBike

) {
    public static Bike criaBike(BikeDTO bikeDTO){

        Bike bike = new Bike();
        bike.setNome(bikeDTO.produto().nome());
        bike.setNomeLongo(bikeDTO.produto().nomeLongo());
        bike.setPreco(bikeDTO.produto().precoVenda());
        bike.setValorCompra(bikeDTO.produto().precoCusto());
        bike.setEstoque(bikeDTO.produto().estoque());
        bike.setImg(new ArrayList<>());
        if(!bikeDTO.produto().img().isEmpty())
            bikeDTO.produto().img().stream().forEach(img -> {
                bike.getImg().add(img);
            });

        return bike;
    }

}