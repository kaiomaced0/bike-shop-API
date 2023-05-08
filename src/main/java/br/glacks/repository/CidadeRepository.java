package br.glacks.repository;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import br.glacks.model.locais.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade> {
    public List<Cidade> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
}
