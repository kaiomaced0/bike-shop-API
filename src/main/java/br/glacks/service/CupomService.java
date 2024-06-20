package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import br.glacks.dto.CupomDTO;
import br.glacks.dto.CupomResponseDTO;
import br.glacks.model.Cupom;

public interface CupomService {
    
    public List<CupomResponseDTO> getAll(int page, int pageSize);

    public long count();

    public CupomResponseDTO getId(@PathParam("id") long id);

    public List<CupomResponseDTO> getNome(@PathParam("nome") String nome);

    public Response insert(CupomDTO cupomDTO);

    public CupomResponseDTO getCodigo(@PathParam("codigo") String codigo);

    public Response update(@PathParam("id") long id, CupomDTO cupom);
    
    public Response delete(@PathParam("id") Long id);

    public Cupom isActive(String codigo);
}
