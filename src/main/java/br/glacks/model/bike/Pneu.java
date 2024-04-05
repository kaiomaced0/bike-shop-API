package br.glacks.model.bike;

import br.glacks.model.EntityClass;
import br.glacks.model.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name = "id")
@Entity
public class Pneu extends Produto {
}
