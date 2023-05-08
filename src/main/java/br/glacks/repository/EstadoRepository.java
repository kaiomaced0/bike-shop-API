package br.glacks.repository;

import jakarta.enterprise.context.ApplicationScoped;

import br.glacks.model.locais.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado>{
    
}
