package com.validation.partner.domain;

import com.validation.component.ExtendedField;
import com.validation.component.FieldValue;
import lombok.Data;

import java.util.List;

@Data
public class Contributors implements ExtendedField {
    private List<AttributeValue> attributes;

    @Override
    public List<? extends FieldValue> getFieldValues() {
        return this.getAttributes();
    }
}
