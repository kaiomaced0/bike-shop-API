package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Carrinho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CarrinhoRepository implements PanacheRepository<Carrinho>{
    
}
