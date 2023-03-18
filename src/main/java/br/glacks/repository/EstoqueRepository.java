package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Estoque;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped  
public class EstoqueRepository implements PanacheRepository<Estoque>{
    
}
