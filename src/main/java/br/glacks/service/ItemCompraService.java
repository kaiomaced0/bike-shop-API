package br.glacks.service;
import java.util.List;

import br.glacks.dto.ItemCompraResponseDTO;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.model.ItemCompra;

public interface ItemCompraService {
    
    List<ItemCompraResponseDTO> getAll();

    ItemCompraResponseDTO getId(@PathParam("id") long id);

    Response insert(ItemCompra itemCompra);

    // public ItemCompra update(@PathParam("id") long id, ItemCompra itemCompra);
    
    Response delete(@PathParam("id") Long id);
}
