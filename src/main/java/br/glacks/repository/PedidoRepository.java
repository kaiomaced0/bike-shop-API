package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido>{
    
}
