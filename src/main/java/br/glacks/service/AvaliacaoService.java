package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.Avaliacao;

public interface AvaliacaoService {
    
    public List<Avaliacao> getAll();

    public Avaliacao getId(@PathParam("id") long id);

    public Response insert(Avaliacao avaliacao);

    public Avaliacao update(@PathParam("id") long id, Avaliacao avaliacao);
    
    public Response delete(@PathParam("id") Long id);
}
