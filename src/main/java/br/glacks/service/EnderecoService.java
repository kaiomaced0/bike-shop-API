package br.glacks.service;
import java.util.List;

import br.glacks.dto.EnderecoDTO;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.dto.EnderecoResponseDTO;
import br.glacks.model.Endereco;

public interface EnderecoService {
    
    public List<EnderecoResponseDTO> getAll();

    public EnderecoResponseDTO getId(@PathParam("id") long id);

    public Response insert(EnderecoDTO enderecoDTO);

    public Response update(@PathParam("id") Long id, EnderecoDTO endereco);
    
    public Response delete(@PathParam("id") Long id);
}
