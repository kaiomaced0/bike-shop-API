package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.dto.PessoaFisicaDTO;
import br.glacks.dto.PessoaFisicaResponseDTO;
import br.glacks.model.PessoaFisica;

public interface PessoaFisicaService {
    
    public List<PessoaFisicaResponseDTO> getAll();

    public PessoaFisica getId(@PathParam("id") long id);

    public List<PessoaFisicaResponseDTO> getNome(@PathParam("nome") String nome);

    public Response insert(PessoaFisicaDTO pessoaFisicaDTO);

    public PessoaFisicaResponseDTO update(@PathParam("id") long id, PessoaFisicaDTO pessoaFisica);
    
    public Response delete(@PathParam("id") Long id);
}
