package dev.dimuth.credit.card.expense.tracker.repository;

import dev.dimuth.credit.card.expense.tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, String> {


    List<Expense> findExpenseByMonth(int monthInteger);
}
