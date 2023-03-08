package br.glacks.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria extends EntityClass{
    
    @ManyToMany
    @JoinColumn(name = "lista_produtos_Categoria")
    private List<Produto> produtos;

    @OneToMany
    @Column(name = "filha_categorias")
    private List<Categoria> categoriasFilha;

    @ManyToOne
    @Column(name = "pai_categorias")
    private List<Categoria> categoriasPai;
}
