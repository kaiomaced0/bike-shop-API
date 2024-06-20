package br.glacks.service;

import br.glacks.dto.FreioDTO;
import br.glacks.dto.ProdutoDTO;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public interface FreioService {

    public Response getAll(int page, int pageSize);

    public long count();

    public Response getId(@PathParam("id") Long id);

    public Response insert(FreioDTO f);

    public Response update(@PathParam("id") Long id, FreioDTO f);

    public Response delete(@PathParam("id") Long id);
}
