package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.locais.Cep;


public interface CepService {
    
    public List<Cep> getAll();

    public Cep getId(@PathParam("id") long id);

    public Response insert(Cep cepDTO);

    public Cep update(@PathParam("id") long id, Cep cep);
    
    public Response delete(@PathParam("id") Long id);
}
