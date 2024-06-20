package br.glacks.service;

import br.glacks.dto.CategoriaDTO;
import br.glacks.dto.PneuDTO;
import br.glacks.dto.ProdutoDTO;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public interface PneuService {

    public Response getAll(int page, int pageSize);

    public Response getAllAdmin(int page, int pageSize);

    public long count();

    public Response getId(@PathParam("id") Long id);

    public Response insert(ProdutoDTO p);

    public Response update(@PathParam("id") Long id, ProdutoDTO p);

    public Response delete(@PathParam("id") Long id);
}
