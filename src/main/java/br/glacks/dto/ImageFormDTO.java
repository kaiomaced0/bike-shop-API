package br.glacks.dto;

import br.glacks.form.ImageForm;
import jakarta.ws.rs.FormParam;

public record ImageFormDTO(
    byte[] imagem,
    String nome
) {
    public static ImageForm criaImageForm(ImageFormDTO imageFormDTO){
        ImageForm i = new ImageForm();
        i.setNome(imageFormDTO.nome);
        i.setImagem(imageFormDTO.imagem);
        return i;
    }
    
}
