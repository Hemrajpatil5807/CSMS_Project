package com.csms.controller;

import com.csms.dto.FinanceDto;
import com.csms.entity.Finance;
import com.csms.service.FinanceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    FinanceServices financeServices;

    @PostMapping("/addexpense")
    public String registerExpense(@RequestBody FinanceDto expensedto) {

        Finance ex = financeServices.addExpense(expensedto);
        if(ex!=null)
            return "Expense Added Succefully !";
        else
            return "Expense Not Added Succefully !";
    }

//	@PostMapping("/addSiteExpense")
//	public String addExpense(@RequestBody Expenses expense) {
//
//		expensesServices.addExpense(expense);
//
//		return "forward:/managerdash";
//
//	}

    @GetMapping("/getsiteexpense")
    public Finance getSiteExpense(@RequestParam int siteId) {

        Finance expense = financeServices.getSiteExpense(siteId);
        if(expense!=null)
            return expense;
        else
            return null;
    }


    @GetMapping("/getallexpenses")
    public List<Finance> getAllExpenses() {

        List<Finance> expenses = financeServices.getAllExpenses();
        if(expenses!=null)
            return expenses;
        else
            return null;
    }

    @PutMapping("/updateexpense")
    public String updateExpense(@RequestBody FinanceDto exp) {

        boolean isUpdate = financeServices.updateExpense(exp);
        if (isUpdate)
            return "Expense Update Successfully !";
        else
            return "Expense Not Updated";
    }

    @DeleteMapping("/deleteexpense")
    public String deleteExpense(@RequestParam int expenseId){
        boolean isDelete = financeServices.deleteExpense(expenseId);
        if(isDelete)
            return "Expense Deleted Successfully";
        else
            return "Expense Not Deleted Successfully";
    }


}
