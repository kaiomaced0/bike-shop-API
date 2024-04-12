package br.glacks.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.glacks.model.EntityClass;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
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
            .stream().filter(EntityClass::getAtivo)
            .sorted(Comparator.comparing(EntityClass::getId))
            .map(PessoaFisicaResponseDTO::new)
            .collect(Collectors.toList());
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getAll()");
            return null;
        }
        
       
        
    }

    @Override
    public Response getId(long id){
        try {
            LOG.info("Requisição PessoaFisica.getId()"); 
        
            return Response.ok(new PessoaFisicaResponseDTO(repository.findById(id))).build();
            
        } catch (Exception e) {
            LOG.error("Erro ao rodar Requisição PessoaFisica.getId()");
            return Response.status(400).entity(e.getMessage()).build();
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
    
    
}
