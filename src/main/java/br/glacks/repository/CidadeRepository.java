package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Locais.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade> {
    
}
