package br.glacks.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.dto.PessoaFisicaDTO;
import br.glacks.dto.PessoaFisicaResponseDTO;
import br.glacks.model.PessoaFisica;
import br.glacks.repository.PessoaFisicaRepository;
import br.glacks.service.PessoaFisicaService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    public static final Logger LOG = Logger.getLogger(PessoaFisicaServiceImpl.class);

    @Inject
    PessoaFisicaRepository repository;
    
    @Override
    public List<PessoaFisicaResponseDTO> getAll(){
        
        
        try {
            LOG.info("Requisição PessoaFisica.getAll()"); 
            return repository.findAll()
            .stream()
            .map(pessoaFisica -> new PessoaFisicaResponseDTO(pessoaFisica))
            .collect(Collectors.toList());
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getAll()");
            return null;
        }
        
       
        
    }

    @Override
    public PessoaFisica getId(long id){
        try {
            LOG.info("Requisição PessoaFisica.getId()"); 
        
            return repository.findById(id);
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getId()");
            return null;
        }
        
    }

    @Override
    public List<PessoaFisicaResponseDTO> getNome(String nome){
        try {
            LOG.info("Requisição PessoaFisica.getNome()"); 
        
            return repository.findByNome(nome)
                .stream()
                .map(pessoaFisica -> new PessoaFisicaResponseDTO(pessoaFisica))
                .collect(Collectors.toList());
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getNome()");
            return null;
        }
        
    }
    
    @Override
    @Transactional
    public Response insert(PessoaFisicaDTO pessoaFisicaDTO){
        try {
            LOG.info("Requisição PessoaFisica.insert()"); 
        
            PessoaFisica pessoaFisica = PessoaFisicaDTO.criaPessoaFisica(pessoaFisicaDTO);
            if(pessoaFisicaDTO != null){
                repository.persist(pessoaFisica);
                return Response.ok(pessoaFisicaDTO).build();
            }
            return Response.notModified().build();
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.insert()");
            return null;
        }
    }

    @Override
    @Transactional
    public PessoaFisicaResponseDTO update(long id, PessoaFisicaDTO pessoafisica){
        try {
            LOG.info("Requisição PessoaFisica.update()"); 
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
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.update()");
            return null;
        }
        
    }
    
   @Override
   @Transactional
   public Response delete(Long id) {
    try {
        LOG.info("Requisição PessoaFisica.delete()"); 
        PessoaFisica entity = repository.findById(id);
        entity.setAtivo(false);
        
        return Response.status(Status.OK).build();
        
    } catch (Exception e) {
        LOG.error("Erro ao rodar Requisição PessoaFisica.delete()");
        return null;
    }
    
    }
    
    
}
