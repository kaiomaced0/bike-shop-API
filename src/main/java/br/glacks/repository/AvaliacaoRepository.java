package br.glacks.repository;

import jakarta.enterprise.context.ApplicationScoped;

import br.glacks.model.Avaliacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AvaliacaoRepository implements PanacheRepository<Avaliacao>{
    
}
