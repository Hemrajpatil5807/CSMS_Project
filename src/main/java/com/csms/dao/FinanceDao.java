package com.csms.dao;

import com.csms.entity.Finance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface FinanceDao extends CrudRepository<Finance, Integer> {

    @Query("SELECT f FROM Finance f WHERE f.siteId.site_id = :siteId")
    Finance findBySiteId(@Param("siteId") int siteId);

}
