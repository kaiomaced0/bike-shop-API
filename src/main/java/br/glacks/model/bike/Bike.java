package br.glacks.model.bike;

import br.glacks.model.Marca;
import jakarta.persistence.*;

import br.glacks.model.Produto;

@PrimaryKeyJoinColumn(name = "id")
@Entity
public class Bike extends Produto{

    private String marcha;

    @ManyToOne
    @JoinColumn(name = "freio")
    private Freio freio;

    private String cambio;

    @Enumerated(EnumType.ORDINAL)
    private Tamanho tamanho;

    @Enumerated(EnumType.ORDINAL)
    private TipoBike tipoBike;

    public String getMarcha() {
        return marcha;
    }

    public void setMarcha(String marcha) {
        this.marcha = marcha;
    }

    public Freio getFreio() {
        return freio;
    }

    public void setFreio(Freio freio) {
        this.freio = freio;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public TipoBike getTipoBike() {
        return tipoBike;
    }

    public void setTipoBike(TipoBike tipoBike) {
        this.tipoBike = tipoBike;
    }
}