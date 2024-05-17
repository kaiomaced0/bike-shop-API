package br.glacks.model;

import jakarta.persistence.Entity;

@Entity
public class Carrossel extends EntityClass{

    private String link;
    private String image;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
