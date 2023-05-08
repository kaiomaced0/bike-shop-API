package br.glacks.repository;

import jakarta.enterprise.context.ApplicationScoped;

import br.glacks.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {
    
}
