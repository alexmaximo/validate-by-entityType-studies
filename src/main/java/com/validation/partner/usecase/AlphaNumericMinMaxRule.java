package com.validation.partner.usecase;

import com.validation.component.ConstraintRule;
import com.validation.component.ConstraintViolation;
import com.validation.component.FieldMeta;
import com.validation.component.FieldType;
import com.validation.component.FieldValue;
import com.validation.partner.domain.enums.AttributeType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AlphaNumericMinMaxRule implements ConstraintRule {
    final List<AttributeType> types = Arrays.asList(AttributeType.URL, AttributeType.STRING);

    @Override
    public boolean isSupported(FieldType type) {
        return types.contains(type);
    }

    @Override
    public Optional<ConstraintViolation> apply(FieldMeta fieldMeta, FieldValue fieldValue) {
        return Optional.empty();
    }
}
