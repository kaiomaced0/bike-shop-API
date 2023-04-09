package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Cor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CorRepository implements PanacheRepository<Cor> {
    
}
