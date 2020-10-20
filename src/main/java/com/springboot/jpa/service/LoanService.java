package com.springboot.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.model.Loan;
//@Transactional( propagation = Propagation.MANDATORY)
public interface LoanService {

	public List<Loan> getLoans();
	//@Transactional( propagation = Propagation.NEVER)
	public Optional<Loan> getLoanById(int empid);
	public Loan addNewLoan(Loan loan);
	public List<Loan> addNewLoanList(List<Loan> loans);
	public Loan updateLoan(Loan loan);
	public void deleteLoanById(int loanid);
	public void deleteAllLoans();
	List<Loan> getAllLoans();

}
