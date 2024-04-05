package br.glacks.repository;

import br.glacks.model.bike.Pneu;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PneuRepository implements PanacheRepository<Pneu> {
}
