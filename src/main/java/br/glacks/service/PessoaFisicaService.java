package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.dto.PessoaFisicaDTO;
import br.glacks.dto.PessoaFisicaResponseDTO;
import br.glacks.model.PessoaFisica;

public interface PessoaFisicaService {
    
    public Response getAll(int page, int pageSize);

    public long count();

    public Response getId(@PathParam("id") long id);

    public List<PessoaFisicaResponseDTO> getNome(@PathParam("nome") String nome);
}
