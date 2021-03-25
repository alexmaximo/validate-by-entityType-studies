package com.validation.partner.usecase;

public interface UseCase<I, R> {
    R execute(I in);
}
