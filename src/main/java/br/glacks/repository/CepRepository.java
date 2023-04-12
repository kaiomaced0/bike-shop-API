package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.locais.Cep;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CepRepository implements PanacheRepository<Cep> {
    
}
