package br.glacks.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.PessoaJuridicaDTO;
import br.glacks.dto.PessoaJuridicaResponseDTO;
import br.glacks.model.PessoaJuridica;
import br.glacks.repository.PessoaJuridicaRepository;
import br.glacks.service.PessoaJuridicaService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {

    @Inject
    PessoaJuridicaRepository repository;
    
    @Override
    public List<PessoaJuridicaResponseDTO> getAll(){
        return repository.findAll()
            .stream()
            .map(pessoaJuridica -> new PessoaJuridicaResponseDTO(pessoaJuridica))
            .collect(Collectors.toList());
        
    }

    @Override
    public PessoaJuridica getId(long id){
        return repository.findById(id);
        
    }

    @Override
    public List<PessoaJuridicaResponseDTO> getNome(String nome){
        return repository.findByNome(nome)
            .stream()
            .map(pessoaJuridica -> new PessoaJuridicaResponseDTO(pessoaJuridica))
            .collect(Collectors.toList());
        
    }
    @Override
    @Transactional
    public Response insert(PessoaJuridicaDTO pessoaJuridicaDTO){
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNome(pessoaJuridicaDTO.usuarioDTO().nome());
        pessoaJuridica.setLogin(pessoaJuridicaDTO.usuarioDTO().login());
        pessoaJuridica.setSenha(pessoaJuridicaDTO.usuarioDTO().senha());
        pessoaJuridica.setCnpj(pessoaJuridicaDTO.cnpj());
        if(pessoaJuridicaDTO != null){
            repository.persist(pessoaJuridica);
            return Response.ok(pessoaJuridicaDTO).build();
        }
        return Response.notModified().build();
        
    }

    @Override
    @Transactional
    public PessoaJuridicaResponseDTO update(long id, PessoaJuridicaDTO pessoaJuridica){
        PessoaJuridica entity = repository.findById(id);
        if(pessoaJuridica.usuarioDTO().login() != null){
            entity.setLogin(pessoaJuridica.usuarioDTO().login());
        }
        if(pessoaJuridica.usuarioDTO().nome() != null){
            entity.setNome(pessoaJuridica.usuarioDTO().nome());
        }
        if(pessoaJuridica.usuarioDTO().senha() != null){
            entity.setSenha(pessoaJuridica.usuarioDTO().senha());
        }
        if(pessoaJuridica.cnpj() != null){
            entity.setCnpj(pessoaJuridica.cnpj());
        }
        return new PessoaJuridicaResponseDTO(entity);
    }
    
   @Override
   @Transactional
   public Response delete(Long id) {
    PessoaJuridica entity = repository.findById(id);
    entity.setAtivo(false);
    
    return Response.status(Status.OK).build();
    }

    
    
}
