package br.glacks.form;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import br.glacks.model.EntityClass;
import jakarta.persistence.Entity;
import jakarta.ws.rs.FormParam;

@Entity
public class ImageForm extends EntityClass{

    @FormParam("imagem")
    @PartType("application/octet-stream")
    private byte[] imagem;
    

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

}
