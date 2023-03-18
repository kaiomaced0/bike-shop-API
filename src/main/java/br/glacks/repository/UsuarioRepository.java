package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;

import br.glacks.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
    
}
