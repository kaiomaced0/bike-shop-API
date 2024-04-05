package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.dto.PessoaJuridicaDTO;
import br.glacks.dto.PessoaJuridicaResponseDTO;
import br.glacks.model.PessoaJuridica;

public interface PessoaJuridicaService {
    
    public List<PessoaJuridicaResponseDTO> getAll();

    public Response getId(@PathParam("id") long id);

    public List<PessoaJuridicaResponseDTO> getNome(@PathParam("nome") String nome);
    
    public List<PessoaJuridicaResponseDTO> getCnpj(@PathParam("cnj") String cnpj);

    public Response insert(PessoaJuridicaDTO pessoajuridicaDTO);

    public PessoaJuridicaResponseDTO update(@PathParam("id") long id, PessoaJuridicaDTO pessoajuridica);
    
    public Response delete(@PathParam("id") Long id);
}
