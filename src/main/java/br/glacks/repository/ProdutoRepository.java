package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto>{
    
}
