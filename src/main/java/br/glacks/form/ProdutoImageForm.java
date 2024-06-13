package br.glacks.form;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class ProdutoImageForm {

    @FormParam("id")
    @PartType(MediaType.TEXT_PLAIN)
    private Long id;
    @FormParam("nomeImagem")
    private String nome;
    
    @FormParam("imagem")
    @PartType("application/octet-stream")
    private byte[] imagem;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
