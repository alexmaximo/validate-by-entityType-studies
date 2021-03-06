package com.validation.partner.domain;

import com.validation.component.FieldValue;
import lombok.Data;

@Data
public class AttributeValue implements FieldValue {
    private String code;
    private String value;
}
