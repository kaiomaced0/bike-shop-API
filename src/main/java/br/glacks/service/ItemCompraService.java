package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.model.ItemCompra;

public interface ItemCompraService {
    
    public List<ItemCompra> getAll();

    public ItemCompra getId(@PathParam("id") long id);

    public Response insert(ItemCompra itemCompra);

    public ItemCompra update(@PathParam("id") long id, ItemCompra itemCompra);
    
    public Response delete(@PathParam("id") Long id);
}
