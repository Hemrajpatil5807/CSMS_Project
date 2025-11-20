package com.csms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinanceDto {

    private int finance_id;

    private int site_id;

    private String expense_type;

    private double amount;

    private LocalDate date;

    public FinanceDto(int site_id, String expense_type, double amount, String date) {

        this.site_id = site_id;
        this.expense_type = expense_type;
        this.amount = amount;
        this.date = LocalDate.parse(date);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
        ;
    }

}
