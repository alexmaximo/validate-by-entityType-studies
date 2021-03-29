package com.validation.partner.usecase;

import com.validation.component.ConstraintViolation;
import com.validation.component.FieldsValidator;
import com.validation.partner.domain.Partner;
import com.validation.partner.domain.enums.AttributeEntityType;
import com.validation.partner.usecase.exceptions.ConstraintViolationsException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UpdatePartnerUseCase implements UseCase<Partner, Optional<Partner>> {
    private final CustomAttributesValidation validators;

    public UpdatePartnerUseCase(final CustomAttributesValidation validators) {
        this.validators = validators;
    }

    @Override
    public Optional<Partner> execute(Partner partner) {
        final String model = partner.getModel();
        final FieldsValidator validator = validators.obtainValidatorForThis(model);
        final List<ConstraintViolation> violations = new ArrayList<>();
        violations.addAll(validator.validate(partner, AttributeEntityType.PARTNER));
        violations.addAll(partner.getBrands().stream().map(brand -> validator.validate(brand, AttributeEntityType.BRAND)).flatMap(Collection::stream)
                .collect(Collectors.toList()));
        violations.addAll(partner.getContributors().stream().map(contributor -> validator.validate(contributor, AttributeEntityType.BRAND))
                .flatMap(Collection::stream).collect(Collectors.toList()));

        if (!violations.isEmpty()) {
            throw new ConstraintViolationsException(violations);
        }
        return Optional.empty();
    }
}