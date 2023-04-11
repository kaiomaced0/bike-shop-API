package br.glacks.converterjpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.glacks.model.TipoListaProduto;

@Converter(autoApply = true)
public class TipoListaProdutoConverter implements AttributeConverter<TipoListaProduto, Integer>{
    @Override
    public Integer convertToDatabaseColumn(TipoListaProduto tipoListaProduto) {
        return tipoListaProduto == null ? null : tipoListaProduto.getId();
    }

    @Override
    public TipoListaProduto convertToEntityAttribute(Integer id) {
        return TipoListaProduto.valueOf(id);
    }
}
