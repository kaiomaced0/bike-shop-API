package br.glacks.converterjpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import br.glacks.model.bike.Tamanho;


@Converter(autoApply = true)
public class TamanhoConverter implements AttributeConverter<Tamanho, Integer>{
    @Override
    public Integer convertToDatabaseColumn(Tamanho tamanho) {
        return tamanho == null ? null : tamanho.getId();
    }

    @Override
    public Tamanho convertToEntityAttribute(Integer id) {
        return Tamanho.valueOf(id);
    }
}
