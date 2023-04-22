package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.ItemCompra;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ItemCompraRepository implements PanacheRepository<ItemCompra>{
    
}
