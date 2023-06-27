package br.glacks.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
            .stream()
            .sorted(Comparator.comparing(pessoaFisica -> pessoaFisica.getId()))
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
    
    
}
