package com.validation.partner.usecase;

import com.validation.component.ConstraintRule;
import com.validation.component.FieldsValidator;
import com.validation.component.FieldType;
import com.validation.partner.domain.enums.AttributeType;
import com.validation.partner.repository.AttributesMetadaRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CustomAttributesValidation {
    private final Map<FieldType, List<ConstraintRule>> rules = new HashMap<>();
    private AttributesMetadaRepository repository = null;

    public CustomAttributesValidation(final AttributesMetadaRepository repository, List<ConstraintRule> rules) {
        this.repository = repository;
        Stream.of(AttributeType.values()).forEach(
                attributeType -> this.rules.put(attributeType, rules.stream().filter(rule -> rule.isSupported(attributeType)).collect(Collectors.toList())));
    }

    @Cacheable
    public FieldsValidator obtainValidatorForThis(final String model) {
        return FieldsValidator.from(new ArrayList<>(repository.findByModel(model)), this.rules);
    }
}
