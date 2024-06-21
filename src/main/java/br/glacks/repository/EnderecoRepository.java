package br.glacks.repository;

import br.glacks.model.Produto;
import jakarta.enterprise.context.ApplicationScoped;

import br.glacks.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {
    public List<Endereco> findByUsuario(String usuario){
        if (usuario == null)
            return null;
        return find("UPPER(usuario) LIKE ?1 ", "%"+usuario.toUpperCase()+"%").list();
    }
    
}
