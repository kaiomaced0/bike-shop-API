package br.glacks.model.Locais;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import br.glacks.model.EntityClass;

public class Estado extends EntityClass{
    @Column(name = "sigla_estado", length = 3)
    @Size(max = 2)
    private String sigla;

    @Column(name = "lista_cidades")
    private List<Cidade> cidades;

    public String getSigla() {
        return sigla.toUpperCase();
    }

    public void setSigla(String sigla) {
        this.sigla = sigla.toUpperCase();
    }

    
}
