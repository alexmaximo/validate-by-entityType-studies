package com.validation.component;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FieldsValidator {
    private final Map<Pair<String, FieldEntityType>, FieldMeta> byFieldCode;
    private final Map<FieldType, List<ConstraintRule>> rules;

    public FieldsValidator(Map<Pair<String, FieldEntityType>, FieldMeta> byFieldCode, Map<FieldType, List<ConstraintRule>> rules) {
        this.byFieldCode = byFieldCode;
        this.rules = rules;
    }

    public static FieldsValidator from(List<FieldMeta> metadata, Map<FieldType, List<ConstraintRule>> rules) {
        Map<Pair<String, FieldEntityType>, FieldMeta> byFieldCode = metadata.stream()
                .collect(Collectors.toMap((item) -> Pair.of(item.getCode(), item.getEntityType()), Function.identity()));
        return new FieldsValidator(byFieldCode, rules);
    }

    public List<ConstraintViolation> validate(final ExtendedField extended, final FieldEntityType entityType) {
        List<ConstraintViolation> violations = new ArrayList<>();
        extended.getFieldValues().forEach(item -> {
            final FieldMeta meta = byFieldCode.get(Pair.of(item.getCode(), entityType));
            if (Objects.isNull(meta)) {
                violations.add(ConstraintViolation.createUnsupportedField(item));
                return;
            }
            List<ConstraintViolation> result = rules.getOrDefault(meta.getType(), Collections.emptyList()).stream().map(rule -> rule.apply(meta, item))
                    .filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
            violations.addAll(result);
        });
        return violations;
    }
}
