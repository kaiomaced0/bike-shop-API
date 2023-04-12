package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.Carrinho;

public interface CarrinhoService {
    
    public List<Carrinho> getAll();

    public Carrinho getId(@PathParam("id") long id);

    public Response insert(Carrinho carrinhoDTO);

    public Carrinho update(@PathParam("id") long id, Carrinho carrinho);
    
    public Response delete(@PathParam("id") Long id);
}
