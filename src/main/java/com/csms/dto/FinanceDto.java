package com.csms.dto;

import com.csms.entity.Users;
import jakarta.persistence.Column;
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

    private String userName;

    private String expense_type;

    private double amount;

    private String currency;

    private LocalDate date;

    private LocalDate modified_on;

    private String gst;

    private String expense_direction;

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }

}
