package br.glacks.model.Locais;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.glacks.model.EntityClass;

@Entity
public class Cep extends EntityClass{

    @ManyToOne
    @JoinColumn(name = "cidade_cep")
    private Cidade cidade;
    
}
