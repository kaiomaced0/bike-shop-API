package br.glacks.service;
import java.util.List;

import br.glacks.dto.ItemCompraDTO;
import br.glacks.dto.ValidaCompraResponseDTO;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.CompraDTO;
import br.glacks.dto.CompraResponseDTO;
import br.glacks.model.Compra;

public interface CompraService {
    
    public Response getAll(int page, int pageSize);

    public long count();

    public Response getValorTeste(List<ItemCompraDTO> listaItemCompra);

    public List<CompraResponseDTO> getAllOn();

    public CompraResponseDTO getId(@PathParam("id") long id);
    
    public Response mudarStatusPedido(long id, int idStatusPedido);

    public Response insert(CompraDTO compraDTO);

    public ValidaCompraResponseDTO verificarCompra(CompraDTO compraDTO);

    // public Compra update(@PathParam("id") long id, Compra compra);
    
    public Response delete(@PathParam("id") Long id);

    public Response realizarPagamentoCompra(@PathParam("id") long id, String tokenPagamento);
}
