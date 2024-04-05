package br.glacks.dto;

import br.glacks.model.bike.Freio;

public record FreioDTO(
        String nome
) {
    public static Freio criaFreio(FreioDTO f){
        Freio freio = new Freio();
        freio.setNome(f.nome);
        return freio;
    }
}
