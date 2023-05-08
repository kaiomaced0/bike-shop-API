package br.glacks.converterjpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import br.glacks.model.pagamento.FormaPagamento;



@Converter(autoApply = true)
public class FormaPagamentoConverter implements AttributeConverter<FormaPagamento, Integer>{
    @Override
    public Integer convertToDatabaseColumn(FormaPagamento formaPagamento) {
        return formaPagamento == null ? null : formaPagamento.getId();
    }

    @Override
    public FormaPagamento convertToEntityAttribute(Integer id) {
        return FormaPagamento.valueOf(id);
    }
}
