package br.glacks.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Telefone extends EntityClass {

    @ManyToOne
    private Usuario proprietario;


}
