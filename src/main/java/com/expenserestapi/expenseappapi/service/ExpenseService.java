package com.expenserestapi.expenseappapi.service;

import com.expenserestapi.expenseappapi.dto.ExpenseDTO;

import java.util.List;

/**
 * Service interface for expense Module
 * @author Rahul Kumar
 */
public interface ExpenseService {
    List<ExpenseDTO> getAllExpense();

    ExpenseDTO getExpenseById(String expenseId);

    void deleteByExpenseId(String expenseId);

    ExpenseDTO saveExpenseDetails(ExpenseDTO expenseDTO);
}
