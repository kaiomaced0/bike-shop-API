package br.glacks.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.Compra;
import br.glacks.model.StatusPedido;
import br.glacks.model.pagamento.FormaPagamento;
import br.glacks.repository.EnderecoRepository;
import br.glacks.service.impl.CupomServiceImpl;
import jakarta.validation.constraints.NotBlank;

public record CompraDTO(
        @NotBlank List<ItemCompraDTO> listaItemCompraDTO,
        Long idCupom,
        Long idEndereco,
        Integer formaPagamento

) {
    public static Compra criaCompra(CompraDTO c) {
        CupomServiceImpl cupom = new CupomServiceImpl();
        EnderecoRepository end = new EnderecoRepository();
        Compra compra = new Compra();
        compra.setListaItemCompra(c.listaItemCompraDTO.stream().map(
                itemCompra -> ItemCompraDTO.criaItemCompra(itemCompra)).collect(Collectors.toList()));
        compra.setCupom(cupom.getId(c.idCupom));
        compra.setEnderecoEntrega(end.findById(c.idEndereco));
        compra.setFormaPagamento(FormaPagamento.valueOf(c.formaPagamento));
        compra.setStatusPedido(StatusPedido.PREPARANDO);
        return compra;
    }

}
