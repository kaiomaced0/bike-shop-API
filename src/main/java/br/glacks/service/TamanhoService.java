package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.dto.TamanhoDTO;
import br.glacks.model.Tamanho;

public interface TamanhoService {
    
    public List<Tamanho> getAll();

    public Tamanho getId(@PathParam("id") long id);

    public Response insert(TamanhoDTO tamanhoDTO);

    public Tamanho update(@PathParam("id") long id, TamanhoDTO tamanho);
    
    public Response delete(@PathParam("id") Long id);
}
