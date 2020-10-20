package com.springboot.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.dao.LoanDao;
import com.springboot.jpa.model.Loan;

@Service
public class LoanServiceImpl implements LoanService{

	@Autowired
	LoanDao dao;
	
	
	@Override
	public List<Loan> getLoans() {
		return dao.findAll();
	}

	@Override
	public Optional<Loan> getLoanById(int loanNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan addNewLoan(Loan loan) {
		return dao.save(loan);
	}

	@Override
	public List<Loan> addNewLoanList(List<Loan> loans) {
		return dao.saveAll(loans);
	}

	@Override
	public Loan updateLoan(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLoanById(int loanNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllLoans() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Loan> getAllLoans() {
		// TODO Auto-generated method stub
		return null;
	}

}
