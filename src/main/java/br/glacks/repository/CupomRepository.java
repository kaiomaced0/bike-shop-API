package br.glacks.repository;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import br.glacks.model.Cupom;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CupomRepository implements PanacheRepository<Cupom>{
    public List<Cupom> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
}
