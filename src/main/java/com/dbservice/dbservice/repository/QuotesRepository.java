package com.dbservice.dbservice.repository;

import java.util.List;

import com.dbservice.dbservice.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;



public interface QuotesRepository extends JpaRepository<Quote, Integer> {

	List<Quote> findByUserName(String username);

}
