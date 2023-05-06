package br.glacks.dto;

import br.glacks.model.Endereco;
import br.glacks.model.locais.Cidade;

public record EnderecoResponseDTO(
    Long id,
    UsuarioResponseDTO usuarioResponseDTO,
    Cidade cidade,
    String cep,
    String rua,
    String numero,
    String descricao
) {
    public EnderecoResponseDTO(Endereco endereco){
        this(endereco.getId(), new UsuarioResponseDTO(endereco.getUsuario()),
        endereco.getCidade(), endereco.getCep(), endereco.getRua(), endereco.getNumero(),
        endereco.getDescricao());
    }
    
}
