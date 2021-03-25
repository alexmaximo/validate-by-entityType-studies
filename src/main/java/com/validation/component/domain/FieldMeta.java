package com.validation.component.domain;

public interface FieldMeta {
    String getCode();

    FieldType getType();

    FieldEntityType getEntityType();

    boolean isRequired();

    int getMinimum();

    int getMaximum();
}
