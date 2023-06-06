package br.glacks.service.impl;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.glacks.model.Cupom;
import br.glacks.repository.CupomRepository;
import br.glacks.service.CupomService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CupomServiceImpl implements CupomService {

    @Inject
    CupomRepository repository;
    
    @Override
    public List<Cupom> getAll(){
        return repository.findAll().list();
        
    }

    @Override
    public Cupom getId(long id){
        return repository.findById(id);
        
    }

    @Override
    public List<Cupom> getNome(String nome){
        return repository.findByNome(nome);
        
    }

    @Override
    @Transactional
    public Response insert(Cupom cupom){
        repository.persist(cupom);
        return Response.ok(cupom).build();
    }

    @Override
    @Transactional
    public Cupom update(long id, Cupom cupom){
        Cupom entity = repository.findById(id);
        entity.setNome(cupom.getNome());
        return entity;
    }
    
   @Override
   @Transactional
    public Response delete(Long id) { 
        Cupom entity = repository.findById(id);
        entity.setAtivo(false);
            
        return Response.status(Status.OK).build();
    }

    
    
}
