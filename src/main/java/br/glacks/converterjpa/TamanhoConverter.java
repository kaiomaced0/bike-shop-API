package br.glacks.converterjpa;

import br.glacks.model.bike.Tamanho;
import jakarta.persistence.AttributeConverter;

public class TamanhoConverter implements AttributeConverter<Tamanho, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Tamanho tamanho) {
        return tamanho == null ? null : tamanho.getId();
    }

    @Override
    public Tamanho convertToEntityAttribute(Integer id) {
        return Tamanho.valueOf(id);
    }
}
