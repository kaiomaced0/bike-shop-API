package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Cupom;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CupomRepository implements PanacheRepository<Cupom>{
    
}
