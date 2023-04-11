package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.PessoaFisica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PessoaFisicaRepository implements PanacheRepository<PessoaFisica>{
    
}
