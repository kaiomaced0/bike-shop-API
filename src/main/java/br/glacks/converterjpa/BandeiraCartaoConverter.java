package br.glacks.converterjpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import br.glacks.model.pagamento.BandeiraCartao;

public class BandeiraCartaoConverter implements AttributeConverter<BandeiraCartao, Integer>{
    @Override
    public Integer convertToDatabaseColumn(BandeiraCartao bandeiraCartao) {
        return bandeiraCartao == null ? null : bandeiraCartao.getId();
    }

    @Override
    public BandeiraCartao convertToEntityAttribute(Integer id) {
        return BandeiraCartao.valueOf(id);
    }
}
