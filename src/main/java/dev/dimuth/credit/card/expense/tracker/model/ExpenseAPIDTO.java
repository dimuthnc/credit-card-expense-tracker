package dev.dimuth.credit.card.expense.tracker.model;

import dev.dimuth.credit.card.expense.tracker.validator.ValidCreditCard;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ExpenseAPIDTO(
        @Min(2020) @Max(2030)
        int year,
        @Min(1) @Max(12)
        int month,
        @NotBlank
        String description,
        double amount,
        ExpenseCategory category,
        @NotBlank(message = "Credit card is not valid")
        @ValidCreditCard
        String card
) {

}
