package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.Pedido;

public interface PedidoService {
    
    public List<Pedido> getAll();

    public Pedido getId(@PathParam("id") long id);

    public Response insert(Pedido pedido) ;

    public Pedido update(@PathParam("id") long id, Pedido pedido);
    
    public Response delete(@PathParam("id") Long id);
}
