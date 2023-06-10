package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.CidadeDTO;
import br.glacks.model.locais.Cidade;

public interface CidadeService {
    
    public List<Cidade> getAll();

    public Cidade getId(@PathParam("id") long id);

    public List<Cidade> getNome(@PathParam("nome") String nome);

    public Response insert(CidadeDTO cidadeDTO);

    public Cidade update(@PathParam("id") long id, CidadeDTO cidade);
    
    public Response delete(@PathParam("id") Long id);
}
