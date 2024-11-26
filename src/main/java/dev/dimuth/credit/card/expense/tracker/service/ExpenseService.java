package dev.dimuth.credit.card.expense.tracker.service;

import dev.dimuth.credit.card.expense.tracker.model.Expense;
import dev.dimuth.credit.card.expense.tracker.model.ExpenseAPIDTO;
import dev.dimuth.credit.card.expense.tracker.repository.ExpenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExpenseService {

    ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void save(ExpenseAPIDTO expense) {
        Expense expense1 = new Expense(expense);
        repository.save(expense1);
    }

    public void removeExpense(String id)  {
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Expense with ID %s does not exists", id));
        } else {
            repository.deleteById(id);
        }
    }

    public void updateExpense(String id, ExpenseAPIDTO expense) {
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Expense with ID %s does not exists", id));
        } else {
            repository.deleteById(id);
            repository.save(new Expense(expense));
        }
    }

    public Expense findExpenseById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Expense> findAll() {
        return repository.findAll();
    }

    public List<Expense> findExpensesByMonth(String month) {
        try {
            return repository.findExpenseByMonth(Integer.parseInt(month));
        }
        catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
