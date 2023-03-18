package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.pagamento.Cartao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CartaoRepository implements PanacheRepository<Cartao>{
    
}
