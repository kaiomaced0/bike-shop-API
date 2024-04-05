package br.glacks.repository;

import br.glacks.model.bike.Freio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FreioRepository implements PanacheRepository<Freio> {
}
