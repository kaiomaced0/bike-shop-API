package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria>{
    
}
