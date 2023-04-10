package br.glacks.dto;

import br.glacks.model.Tamanho;

public class TamanhoDTO {
    private String nome;

    public static Tamanho criarTamanho(TamanhoDTO tamanhoDTO){
        Tamanho tamanho = new Tamanho();
        tamanho.setNome(tamanhoDTO.getNome());
        return tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
