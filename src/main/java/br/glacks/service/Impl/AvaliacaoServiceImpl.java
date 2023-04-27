package br.glacks.service.Impl;

import java.util.List;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.glacks.model.Avaliacao;
import br.glacks.repository.AvaliacaoRepository;
import br.glacks.service.AvaliacaoService;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvaliacaoServiceImpl implements AvaliacaoService {

    @Inject
    AvaliacaoRepository repository;
    
    @Override
    public List<Avaliacao> getAll(){
        return repository.findAll().list();
        
    }

    @Override
    public Avaliacao getId(long id){
        return repository.findById(id);
        
    }

    @Override
    @Transactional
    public Response insert(Avaliacao avaliacao){
        repository.persist(avaliacao);
        return Response.ok(avaliacao).build();
    }

    @Override
    @Transactional
    public Avaliacao update(long id, Avaliacao avaliacao){
        Avaliacao entity = repository.findById(id);
        entity.setNome(avaliacao.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
