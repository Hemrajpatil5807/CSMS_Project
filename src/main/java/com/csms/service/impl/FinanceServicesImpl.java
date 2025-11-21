package com.csms.service.impl;

import com.csms.dao.FinanceDao;
import com.csms.dao.SitesDao;
import com.csms.dao.UsersDao;
import com.csms.dto.FinanceDto;
import com.csms.entity.Finance;
import com.csms.entity.Sites;
import com.csms.entity.Users;
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

    @Autowired
    UsersDao usersDao;

    Finance ex = new Finance();

    @Override
    public Finance addExpense(FinanceDto expensedto) {

        Optional<Sites> os = sitesDao.findById(expensedto.getSite_id());
        if (os.isPresent()) {
            ex.setSiteId(os.get());
            ex.setUser_id(usersDao.findByName(expensedto.getUserName()));
            ex.setExpense_type(expensedto.getExpense_type());
            ex.setAmount(expensedto.getAmount());
            ex.setCurrency(expensedto.getCurrency());
            ex.setDate(expensedto.getDate());
            ex.setModified_on(expensedto.getModified_on());
            ex.setGst(expensedto.getGst());
            ex.setExpense_direction(expensedto.getExpense_direction());
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
    public Finance getSiteExpense(int siteId) {
        Finance ex = financeDao.findBySiteId(siteId);
        if(ex != null)
            return ex;
        else
            return null;
    }

    @Override
    public boolean updateExpense(FinanceDto exp) {

        return financeDao.findById(exp.getFinance_id()).map(ex ->{

            Optional<Sites> os = sitesDao.findById(exp.getSite_id());
            ex.setSiteId(os.get());
            ex.setUser_id(usersDao.findByName(exp.getUserName()));
            ex.setExpense_type(exp.getExpense_type());
            ex.setAmount(exp.getAmount());
            ex.setCurrency(exp.getCurrency());
            ex.setDate(exp.getDate());
            ex.setModified_on(exp.getModified_on());
            ex.setGst(exp.getGst());
            ex.setExpense_direction(exp.getExpense_direction());

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
