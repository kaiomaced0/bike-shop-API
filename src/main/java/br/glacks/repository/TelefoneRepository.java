package br.glacks.repository;

import jakarta.enterprise.context.ApplicationScoped;

import br.glacks.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {
}
