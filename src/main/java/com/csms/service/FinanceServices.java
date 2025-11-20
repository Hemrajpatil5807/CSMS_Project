package com.csms.service;

import com.csms.dto.FinanceDto;
import com.csms.entity.Finance;

import java.util.List;

public interface FinanceServices {

    Finance addExpense(FinanceDto expensedto);

    List<Finance> getAllExpenses();

    Finance getSiteExpense(int site_id);

    boolean deleteExpense(int expense_id);

    boolean updateExpense(FinanceDto exp);
}
