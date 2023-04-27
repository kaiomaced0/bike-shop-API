package br.glacks.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.dto.PessoaFisicaDTO;
import br.glacks.model.PessoaFisica;
import br.glacks.repository.PessoaFisicaRepository;
import br.glacks.service.PessoaFisicaService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    @Inject
    PessoaFisicaRepository repository;
    
    @Override
    public List<PessoaFisica> getAll(){
        return repository.findAll().list();
        
    }

    @Override
    public PessoaFisica getId(long id){
        return repository.findById(id);
        
    }

    @Override
    public List<PessoaFisica> getNome(String nome){
        return repository.findByNome(nome);
        
    }
    
    @Override
    @Transactional
    public Response insert(PessoaFisicaDTO pessoaFisicaDTO){
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome(pessoaFisicaDTO.usuarioDTO().nome());
        pessoaFisica.setLogin(pessoaFisicaDTO.usuarioDTO().login());
        pessoaFisica.setSenha(pessoaFisicaDTO.usuarioDTO().senha());
        pessoaFisica.setCpf(pessoaFisicaDTO.cpf());
        if(pessoaFisicaDTO != null){
            repository.persist(pessoaFisica);
            return Response.ok(pessoaFisicaDTO).build();
        }
        return Response.notModified().build();
    }

    @Override
    @Transactional
    public PessoaFisica update(long id, PessoaFisicaDTO pessoafisica){
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
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    
}
