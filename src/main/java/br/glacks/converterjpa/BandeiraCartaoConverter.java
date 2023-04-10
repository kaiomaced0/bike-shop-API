package br.glacks.converterjpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.glacks.model.pagamento.BandeiraCartao;

@Converter(autoApply = true)
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
