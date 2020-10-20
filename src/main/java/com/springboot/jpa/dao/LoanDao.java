package com.springboot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.model.Loan;

@Repository
public interface LoanDao extends JpaRepository<Loan, Integer> {
	
	//@Query("select l from Loan l where l.loan_number like %?1")
    //List<Loan> findByNameEndsWith(String chars);
	
}
		