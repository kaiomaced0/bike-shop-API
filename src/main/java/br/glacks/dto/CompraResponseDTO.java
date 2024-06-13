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
        Long id,
        Long usuarioId,
        String loginUsuario,

        List<ItemCompraResponseDTO> listaItemCompraResponseDTO,

        Double valorTotal,

        String formaPagamento,

        String statusPedido,

        String token,

        String codigoRastreio,

        String dataPrevista,

        String dataEntrega,

        Long idEnderecoEntrega,

        Boolean pago,

        Long idCupom) {

    public CompraResponseDTO (Compra compra){
                this(compra.getId(),
                        compra.getUsuario().getId(),
                        compra.getUsuario().getLogin(),
                        compra.getListaItemCompra() != null ? compra.getListaItemCompra().stream()
                            .map(itemCompra -> new ItemCompraResponseDTO(itemCompra.getProduto().getId(),
                                    itemCompra.getQuantidade(), itemCompra.getPreco()))
                            .collect(Collectors.toList()): null,
                     compra.getValorTotal(),
            compra.getFormaPagamento().getLabel(),
                        compra.getStatusPedido().getLabel(),
                        compra.getToken(),
                        compra.getCodigoRastreio(),
                compra.getDataPrevista(),
                        compra.getDataEntrega(),
                        compra.getEnderecoEntrega() != null ? compra.getEnderecoEntrega().getId() : null,
                        compra.getPago(),
                compra.getCupom() != null ? compra.getCupom().getId() : null);
    }

}
