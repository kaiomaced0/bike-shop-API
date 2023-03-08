package br.glacks.model.Locais;

import javax.persistence.ManyToOne;

import br.glacks.model.EntityClass;

public class Cep extends EntityClass{

    @ManyToOne
    private Cidade cidade;
    
}
