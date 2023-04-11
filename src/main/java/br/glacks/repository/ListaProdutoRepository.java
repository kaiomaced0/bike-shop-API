package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.ListaProduto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ListaProdutoRepository implements PanacheRepository<ListaProduto>{
    
}
