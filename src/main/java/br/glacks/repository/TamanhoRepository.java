package br.glacks.repository;
import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Tamanho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TamanhoRepository implements PanacheRepository<Tamanho> {
    
}
