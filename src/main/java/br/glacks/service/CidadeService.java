package br.glacks.service;
import java.util.List;

import br.glacks.dto.CidadeResponseDTO;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.CidadeDTO;
import br.glacks.model.locais.Cidade;

public interface CidadeService {
    
    public Response getAll();

    public Response getId(@PathParam("id") long id);

    public Response getNome(@PathParam("nome") String nome);

    public Response insert(CidadeDTO cidadeDTO);

    public Cidade update(@PathParam("id") long id, CidadeDTO cidade);
    
    public Response delete(@PathParam("id") Long id);
}
