package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Compra;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CompraRepository implements PanacheRepository<Compra>{
    
}
