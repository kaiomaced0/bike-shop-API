package br.glacks.repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import br.glacks.model.PessoaJuridica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PessoaJuridicaRepository implements PanacheRepository<PessoaJuridica> {
    public List<PessoaJuridica> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
}
