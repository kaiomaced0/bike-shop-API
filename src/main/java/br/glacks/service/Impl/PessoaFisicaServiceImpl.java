package br.glacks.service.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.dto.PessoaFisicaDTO;
import br.glacks.dto.PessoaFisicaResponseDTO;
import br.glacks.model.PessoaFisica;
import br.glacks.repository.PessoaFisicaRepository;
import br.glacks.service.PessoaFisicaService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    @Inject
    PessoaFisicaRepository repository;
    
    @Override
    public List<PessoaFisicaResponseDTO> getAll(){
        return repository.findAll()
            .stream()
            .map(pessoaFisica -> new PessoaFisicaResponseDTO(pessoaFisica))
            .collect(Collectors.toList());
        
    }

    @Override
    public PessoaFisica getId(long id){
        return repository.findById(id);
        
    }

    @Override
    public List<PessoaFisicaResponseDTO> getNome(String nome){
        return repository.findByNome(nome)
            .stream()
            .map(pessoaFisica -> new PessoaFisicaResponseDTO(pessoaFisica))
            .collect(Collectors.toList());
        
    }
    
    @Override
    @Transactional
    public Response insert(PessoaFisicaDTO pessoaFisicaDTO){
        PessoaFisica pessoaFisica = PessoaFisicaDTO.criaPessoaFisica(pessoaFisicaDTO);
        if(pessoaFisicaDTO != null){
            repository.persist(pessoaFisica);
            return Response.ok(pessoaFisicaDTO).build();
        }
        return Response.notModified().build();
    }

    @Override
    @Transactional
    public PessoaFisicaResponseDTO update(long id, PessoaFisicaDTO pessoafisica){
        PessoaFisica entity = repository.findById(id);
        if(pessoafisica.usuarioDTO().login() != null){
            entity.setLogin(pessoafisica.usuarioDTO().login());
        }
        if(pessoafisica.usuarioDTO().nome() != null){
            entity.setNome(pessoafisica.usuarioDTO().nome());
        }
        if(pessoafisica.usuarioDTO().senha() != null){
            entity.setSenha(pessoafisica.usuarioDTO().senha());
        }
        if(pessoafisica.cpf() != null){
            entity.setCpf(pessoafisica.cpf());
        }
        return new PessoaFisicaResponseDTO(entity);
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    
}
