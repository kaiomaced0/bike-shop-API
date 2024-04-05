package br.glacks.repository;

import br.glacks.model.Ferramenta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FerramentaRepository implements PanacheRepository<Ferramenta> {
}
