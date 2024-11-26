package dev.dimuth.credit.card.expense.tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "expense", schema = "dbo")
@Entity
public class Expense{
    public Expense(int year, int month, String description, double amount, ExpenseCategory category, String card) {

        this.year = year;
        this.month = month;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.card = card;
    }

    public Expense(ExpenseAPIDTO expenseAPIDTO){
        this.year = expenseAPIDTO.year();
        this.month = expenseAPIDTO.month();
        this.description = expenseAPIDTO.description();
        this.amount = expenseAPIDTO.amount();
        this.category = expenseAPIDTO.category();
        this.card = expenseAPIDTO.card();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    int year;
    int month;
    String description;
    double amount;
    ExpenseCategory category;
    String card;
}

