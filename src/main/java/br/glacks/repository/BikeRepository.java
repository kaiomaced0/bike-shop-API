package br.glacks.repository;
import javax.enterprise.context.ApplicationScoped;
import br.glacks.model.bike.Bike;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BikeRepository implements PanacheRepository<Bike>{


    
}
