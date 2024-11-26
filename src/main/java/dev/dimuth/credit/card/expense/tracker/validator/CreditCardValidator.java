package dev.dimuth.credit.card.expense.tracker.validator;


import dev.dimuth.credit.card.expense.tracker.config.ExpenseControllerConfigs;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

public class CreditCardValidator implements ConstraintValidator<ValidCreditCard, String> {

    private final List<String> validCards;

    ExpenseControllerConfigs configs;

    public CreditCardValidator(ExpenseControllerConfigs configs) {
        this.validCards = Arrays.stream(configs.getValidCreditCards().toLowerCase().split(",")).toList();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }
        return validCards.contains(value.toLowerCase());
    }
}

