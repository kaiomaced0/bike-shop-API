package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.locais.Cidade;

public interface CidadeService {
    
    public List<Cidade> getAll();

    public Cidade getId(@PathParam("id") long id);

    public Response insert(Cidade cidadeDTO);

    public Cidade update(@PathParam("id") long id, Cidade cidade);
    
    public Response delete(@PathParam("id") Long id);
}
