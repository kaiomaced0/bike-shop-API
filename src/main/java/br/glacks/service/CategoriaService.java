package br.glacks.service;

import br.glacks.dto.BikeDTO;
import br.glacks.dto.CategoriaDTO;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public interface CategoriaService {

    public Response getAll();

    public long count();
    public Response getAllAdmin(int page, int pageSize);

    public Response getId(@PathParam("id") Long id);

    public Response insert(CategoriaDTO c);

    public Response update(@PathParam("id") Long id, CategoriaDTO c);

    public Response delete(@PathParam("id") Long id);
}
