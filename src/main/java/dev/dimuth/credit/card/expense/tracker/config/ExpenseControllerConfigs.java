package dev.dimuth.credit.card.expense.tracker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "expense.controller")
@Getter
@Setter
public class ExpenseControllerConfigs {

    private String validCreditCards;
}
