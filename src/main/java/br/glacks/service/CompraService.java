package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.Compra;

public interface CompraService {
    
    public List<Compra> getAll();

    public Compra getId(@PathParam("id") long id);

    public Response insert(Compra compraDTO);

    public Compra update(@PathParam("id") long id, Compra compra);
    
    public Response delete(@PathParam("id") Long id);
}