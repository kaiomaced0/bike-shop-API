package br.glacks.model.Locais;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.glacks.model.EntityClass;

@Entity
public class Cep extends EntityClass{

    @ManyToOne
    private Cidade cidade;
    
}
