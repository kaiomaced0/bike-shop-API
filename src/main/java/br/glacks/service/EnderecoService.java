package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.dto.EnderecoResponseDTO;
import br.glacks.model.Endereco;

public interface EnderecoService {
    
    public List<EnderecoResponseDTO> getAll();

    public EnderecoResponseDTO getId(@PathParam("id") long id);

    public Response insert(Endereco enderecoDTO);

    public Endereco update(@PathParam("id") long id, Endereco endereco);
    
    public Response delete(@PathParam("id") Long id);
}
