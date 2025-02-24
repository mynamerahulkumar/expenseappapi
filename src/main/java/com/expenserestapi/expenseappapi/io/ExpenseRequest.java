package com.expenserestapi.expenseappapi.io;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseRequest {

    @NotBlank(message = "Expense name is required")// it is combination of not null ,not empty,not only spaces
    @Size(min=3,message = "Expense name should be at least three character")
    private String name;

    private String note;

    @NotBlank(message = "Expense category is required")
    private  String category;
    @NotNull(message = "Expense category is required")
    private Date date;

    @NotNull(message = "Expense amount is required")
    private BigDecimal amount;
}
