package com.csms.service.impl;

import com.csms.dao.FinanceDao;
import com.csms.dao.SitesDao;
import com.csms.dto.FinanceDto;
import com.csms.entity.Finance;
import com.csms.entity.Sites;
import com.csms.service.FinanceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceServicesImpl implements FinanceServices {

    @Autowired
    FinanceDao financeDao;

    @Autowired
    SitesDao sitesDao;

    Finance ex = new Finance();

    @Override
    public Finance addExpense(FinanceDto expensedto) {

        Optional<Sites> os = sitesDao.findById(expensedto.getSite_id());

        if (os.isPresent()) {

            ex.setSite_id(os.get());
            ex.setExpense_type(expensedto.getExpense_type());
            ex.setAmount(expensedto.getAmount());
            ex.setDate(expensedto.getDate());

            financeDao.save(ex);
            return ex;
        }

        return null;
    }

    @Override
    public List<Finance> getAllExpenses() {

        List<Finance> exp = (List<Finance>) financeDao.findAll();

        if (exp != null)
            return exp;
        else
            return null;
    }

    @Override
    public Finance getSiteExpense(int site_id) {

        Finance ex = financeDao.findBySiteId(site_id);

        if (ex != null)
            return ex;
        else
            return null;
    }

    @Override
    public boolean updateExpense(FinanceDto exp) {

        return financeDao.findById(exp.getFinance_id()).map(ex ->{

            Optional<Sites> os = sitesDao.findById(exp.getSite_id());

            ex.setSite_id(os.get());
            ex.setExpense_type(exp.getExpense_type());
            ex.setDate(exp.getDate());
            ex.setAmount(exp.getAmount());

            financeDao.save(ex);
            return true;

        }).orElse(false);


    }

    @Override
    public boolean deleteExpense(int expense_id) {
        financeDao.deleteById(expense_id);

        Optional<Finance> oex = financeDao.findById(expense_id);
        if (oex.isEmpty())
            return true;
        else
            return false;
    }

}
