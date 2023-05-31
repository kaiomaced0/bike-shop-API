package br.glacks.dto;

import br.glacks.model.Telefone;

public record TelefoneResponseDTO(
    UsuarioResponseDTO idProprietario,
    String codigoArea,
    String numero
) {
    public TelefoneResponseDTO(Telefone telefone){
        this((new UsuarioResponseDTO(telefone.getProprietario())), telefone.getCodigoArea(), telefone.getNumero());
    }
    
}
