package com.validation.component;

import com.validation.component.domain.FieldMeta;
import com.validation.component.domain.FieldType;
import com.validation.component.domain.FieldValue;

import java.util.Optional;

public interface ConstraintRule {
    boolean isSupported(FieldType type);

    Optional<ConstraintViolation> apply(FieldMeta fieldMeta, FieldValue fieldValue);
}
