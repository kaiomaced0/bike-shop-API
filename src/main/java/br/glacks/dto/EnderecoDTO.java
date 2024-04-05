package br.glacks.dto;

import br.glacks.model.Endereco;

public record EnderecoDTO(
    String nome,
    Long idCidade,
    String cep,
    String rua , 
    String numero

) {
    public static Endereco criaEndereco(EnderecoDTO e){
        Endereco endereco = new Endereco();
        endereco.setNome(e.nome);
        endereco.setCep(e.cep);
        endereco.setRua(e.rua);
        endereco.setNumero(e.numero);
        return endereco;
    }
    
}
