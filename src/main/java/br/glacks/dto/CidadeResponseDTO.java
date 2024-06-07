package br.glacks.dto;

import br.glacks.model.locais.Cidade;

public record CidadeResponseDTO(
    Long id,
    String nome,
    String estado
) {
    public CidadeResponseDTO(Cidade cidade){
        this(cidade.getId(), cidade.getNome(), cidade.getEstado().getNome());
    }
    
}
