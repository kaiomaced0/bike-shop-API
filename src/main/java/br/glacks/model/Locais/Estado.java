package br.glacks.model.Locais;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import br.glacks.model.EntityClass;

@Entity
public class Estado extends EntityClass{
    @Column(name = "sigla_estado", length = 3)
    @Size(max = 3)
    private String sigla;

    @JoinColumn(name = "lista_cidades")
    @OneToMany
    private List<Cidade> cidades;

    public String getSigla() {
        return sigla.toUpperCase();
    }

    public void setSigla(String sigla) {
        this.sigla = sigla.toUpperCase();
    }

    
}
