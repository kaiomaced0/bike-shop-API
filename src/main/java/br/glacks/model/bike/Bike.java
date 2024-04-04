package br.glacks.model.bike;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;

import br.glacks.model.Produto;

@PrimaryKeyJoinColumn(name = "id")
@Entity
public class Bike extends Produto{

    private String marcha;

    private String freio;

    private String cambio;

    private String observacao;

    private String marca;

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

    public String getFreio() {
        return freio;
    }

    public void setFreio(String freio) {
        this.freio = freio;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoBike getTipoBike() {
        return tipoBike;
    }

    public void setTipoBike(TipoBike tipoBike) {
        this.tipoBike = tipoBike;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }



}