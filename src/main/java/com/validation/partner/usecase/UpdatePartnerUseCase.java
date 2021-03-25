package com.validation.partner.usecase;

import com.validation.component.ConstraintViolation;
import com.validation.partner.domain.Partner;
import com.validation.partner.domain.enums.AttributeEntityType;
import com.validation.partner.exceptions.ConstraintViolationsException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Component
public class UpdatePartnerUseCase implements UseCase<Partner, Optional<Partner>> {

    private final CustomAttributesValidation validators;

    public UpdatePartnerUseCase(final CustomAttributesValidation validators) {
        this.validators = validators;
    }

    @Override
    public Optional<Partner> execute(Partner partner) {
        final String model = partner.getModel();
        List<ConstraintViolation> violations = validators.obtainValidatorForThis(model).validate(partner, AttributeEntityType.PARTNER);

        if (!CollectionUtils.isEmpty(violations)) {
            throw new ConstraintViolationsException(violations);
        }
        return Optional.empty();
    }
}
