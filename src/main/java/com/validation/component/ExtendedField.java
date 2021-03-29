package com.validation.component;

import java.util.List;

public interface ExtendedField {
    List<? extends FieldValue> getFieldValues();
}
