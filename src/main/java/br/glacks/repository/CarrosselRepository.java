package br.glacks.repository;

import br.glacks.model.Carrossel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarrosselRepository implements PanacheRepository<Carrossel> {
}
