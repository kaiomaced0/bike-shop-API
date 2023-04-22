package br.glacks.converterjpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.glacks.model.bike.TipoBike;


@Converter(autoApply = true)
public class TipoBikeConverter implements AttributeConverter<TipoBike, Integer>{
    @Override
    public Integer convertToDatabaseColumn(TipoBike tipobike) {
        return tipobike == null ? null : tipobike.getId();
    }

    @Override
    public TipoBike convertToEntityAttribute(Integer id) {
        return TipoBike.valueOf(id);
    }
}
