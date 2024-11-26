package dev.dimuth.credit.card.expense.tracker.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CreditCardValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCreditCard {

    String message() default "Invalid credit card";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
