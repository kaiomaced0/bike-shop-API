package br.glacks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name = "id")
@Entity
public class Ferramenta extends Produto{

}
