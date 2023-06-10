package br.glacks.dto;

import br.glacks.model.locais.Cidade;

public record EnderecoDTO(
    Long id,
    String nome,
    Cidade cidade,
    String cep,
    String rua , 
    String numero

) {
    
}
