package br.glacks.repository;

import br.glacks.model.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FornecedorRepository  implements PanacheRepository<Fornecedor> {

}
