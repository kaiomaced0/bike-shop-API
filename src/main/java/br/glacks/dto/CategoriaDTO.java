package br.glacks.dto;

import br.glacks.model.Categoria;

public record CategoriaDTO(
        String nome
) {
    public static Categoria criaCategoria(CategoriaDTO categoriaDTO){
        Categoria c = new Categoria();
        c.setNome(categoriaDTO.nome);
        return c;
    }
}
