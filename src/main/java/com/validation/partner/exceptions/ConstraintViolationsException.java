package com.validation.partner.exceptions;

import com.validation.component.ConstraintViolation;

import java.util.List;

public class ConstraintViolationsException extends RuntimeException {
    public ConstraintViolationsException(List<ConstraintViolation> violationList) {

    }
}
