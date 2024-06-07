package br.glacks.dto;

import java.util.List;

import br.glacks.model.Compra;
import br.glacks.model.StatusPedido;
import br.glacks.model.pagamento.FormaPagamento;
import jakarta.validation.constraints.NotBlank;

public record CompraDTO(
        @NotBlank List<ItemCompraDTO> listaItemCompra,
        String idCupom,
        Long idEndereco,
        Integer formaPagamento

) {
    public static Compra criaCompra(CompraDTO c) {
        Compra compra = new Compra();
        compra.setStatusPedido(StatusPedido.PREPARANDO);
        compra.setFormaPagamento(FormaPagamento.valueOf(c.formaPagamento()));
        return compra;
    }

}
