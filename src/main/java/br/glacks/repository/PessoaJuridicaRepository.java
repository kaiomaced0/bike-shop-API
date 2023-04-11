package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.PessoaJuridica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PessoaJuridicaRepository implements PanacheRepository<PessoaJuridica> {
    
}
