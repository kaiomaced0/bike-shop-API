package br.glacks.dto;

import br.glacks.model.Marca;

public record MarcaDTO(String nome) {
    public static Marca criaMarca(MarcaDTO m){
        Marca marca = new Marca();
        marca.setNome(m.nome);
        return marca;
    }
}
