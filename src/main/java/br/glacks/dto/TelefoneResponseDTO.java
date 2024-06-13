package br.glacks.dto;

import br.glacks.model.Telefone;

public record TelefoneResponseDTO(
    Long id,
    Long idProprietario,
    String codigoArea,
    String numero
) {
    public TelefoneResponseDTO(Telefone telefone){
        this(telefone.getId(), telefone.getProprietario().getId(), telefone.getCodigoArea(), telefone.getNumero());
    }
    
}
