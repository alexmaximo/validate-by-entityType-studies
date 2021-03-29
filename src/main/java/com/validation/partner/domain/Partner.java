package com.validation.partner.domain;

import com.validation.component.ExtendedField;
import com.validation.component.FieldValue;
import lombok.Data;

import java.util.List;

@Data
public class Partner implements ExtendedField {
    private String model;
    private List<AttributeValue> attributes;
    private List<Brand> brands;
    private List<Contributors> contributors;

    @Override
    public List<? extends FieldValue> getFieldValues() {
        return this.getAttributes();
    }
}
