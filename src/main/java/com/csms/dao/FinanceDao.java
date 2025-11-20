package com.csms.dao;

import com.csms.entity.Finance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceDao extends CrudRepository<Finance, Integer> {

    Finance findBySiteId(int site_id);
}
