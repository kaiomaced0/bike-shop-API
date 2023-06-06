package br.glacks.service.impl;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.model.locais.Cidade;
import br.glacks.repository.CidadeRepository;
import br.glacks.service.CidadeService;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService {

    @Inject
    CidadeRepository repository;

    private static final Logger LOG = Logger.getLogger(CidadeServiceImpl.class);

    
    @Override
    public List<Cidade> getAll(){
        LOG.info("BUscando todas as cidades");
        return repository.findAll().list();
        
    }

    @Override
    public Cidade getId(long id){
        return repository.findById(id);
        
    }

    @Override
    public List<Cidade> getNome(String nome){
        return repository.findByNome(nome);
        
    }

    @Override
    @Transactional
    public Response insert(Cidade cidade){
        repository.persist(cidade);
        return Response.ok(cidade).build();
    }

    @Override
    @Transactional
    public Cidade update(long id, Cidade cidade){
        
        Cidade entity = repository.findById(id);
        entity.setNome(cidade.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        Cidade entity = repository.findById(id);
        entity.setAtivo(false);
            
        return Response.status(Status.OK).build();
    }

    
    
}
