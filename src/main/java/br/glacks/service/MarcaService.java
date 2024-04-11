package br.glacks.service;

import br.glacks.dto.MarcaDTO;
import br.glacks.dto.ProdutoDTO;
import jakarta.ws.rs.core.Response;

public interface MarcaService {

    public Response getAll();

    public Response getId(Long id);
    public Response insert(MarcaDTO m);
    public Response update(Long id, MarcaDTO m);

    public Response delete(Long id);
}
