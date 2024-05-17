package br.glacks.repository;

import br.glacks.model.HomeConfig;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HomeConfigRepository implements PanacheRepository<HomeConfig> {
}
