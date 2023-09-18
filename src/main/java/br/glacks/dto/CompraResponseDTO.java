package br.glacks.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.Compra;
import br.glacks.model.Cupom;
import br.glacks.model.StatusPedido;
import br.glacks.model.pagamento.FormaPagamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record CompraResponseDTO(
        Long usuarioId,

        List<ItemCompraResponseDTO> listaItemCompraResponseDTO,

        Double valorTotal,

        @Enumerated(EnumType.ORDINAL) FormaPagamento formaPagamento,

        @Enumerated(EnumType.ORDINAL) StatusPedido statusPedido,

        String token,

        String codigoRastreio,

        String dataPrevista,

        String dataEntrega,

        EnderecoResponseDTO enderecoEntrega,

        Boolean pago,

        CupomResponseDTO cupom) {

    public CompraResponseDTO (Compra compra){
                this(compra.getUsuario().getId(), compra.getListaItemCompra().stream()
                            .map(itemCompra -> new ItemCompraResponseDTO(itemCompra.getProduto().getId(), itemCompra.getQuantidade(), itemCompra.getPreco()))
                            .collect(Collectors.toList()),
                     compra.getValorTotal(),
            compra.getFormaPagamento(), compra.getStatusPedido(), compra.getToken(), compra.getCodigoRastreio(),
                compra.getDataPrevista(), compra.getDataEntrega(), new EnderecoResponseDTO(compra.getEnderecoEntrega()), compra.getPago(),
                new CupomResponseDTO(compra.getCupom()));
    }

}
