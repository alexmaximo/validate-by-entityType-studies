package com.validation.component;

import java.util.Optional;

public interface ConstraintRule {
    boolean isSupported(FieldType type);

    Optional<ConstraintViolation> apply(FieldMeta fieldMeta, FieldValue fieldValue);
}
