package com.expenserestapi.expenseappapi.repository;

import com.expenserestapi.expenseappapi.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ExpenseRepository  extends JpaRepository<ExpenseEntity,Long> {

   Optional<ExpenseEntity> findByExpenseId(String expenseId);

}
