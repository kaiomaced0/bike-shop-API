package br.glacks.dto;

import br.glacks.model.Telefone;

public record TelefoneResponseDTO(
    long id,
    UsuarioResponseDTO idProprietario,
    String codigoArea,
    String numero
) {
    public TelefoneResponseDTO(Telefone telefone){
        this(telefone.getId(), (new UsuarioResponseDTO(telefone.getProprietario())), telefone.getCodigoArea(), telefone.getNumero());
    }
    
}
