package br.glacks.repository;
import javax.enterprise.context.ApplicationScoped;
import br.glacks.model.bike.Bike;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;

@ApplicationScoped
public class BikeRepository implements PanacheRepository<Bike>{
    public List<Bike> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }

    
}
