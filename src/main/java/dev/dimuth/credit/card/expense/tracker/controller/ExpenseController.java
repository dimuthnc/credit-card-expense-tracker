package dev.dimuth.credit.card.expense.tracker.controller;


import dev.dimuth.credit.card.expense.tracker.model.Expense;
import dev.dimuth.credit.card.expense.tracker.model.ExpenseAPIDTO;
import dev.dimuth.credit.card.expense.tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
@CrossOrigin
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("")
    public List<Expense> getAllExpenses(){
        return expenseService.findAll();
    }

    @GetMapping("/{month}")
    public List<Expense> getExpensesForMonth(@PathVariable String month){
        return expenseService.findExpensesByMonth(month);
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable("id") String id){
        return expenseService.findExpenseById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void AddExpense(@Valid @RequestBody ExpenseAPIDTO expense){
        expenseService.save(expense);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteExpenseById(@PathVariable("id") String id){
        expenseService.removeExpense(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public void updateExpenseById(@Valid @RequestBody ExpenseAPIDTO expense, @PathVariable("id") String id){
        expenseService.updateExpense(id, expense);
    }
}
