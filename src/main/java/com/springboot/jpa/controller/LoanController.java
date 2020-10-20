package com.springboot.jpa.controller;

import java.util.List;
import java.util.Optional;


import com.springboot.jpa.service.LoanService;
import com.springboot.jpa.dao.LoanDao;
import com.springboot.jpa.model.Loan;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin(origins = {"${cors.url}"})
@Api(value = "LoanController", description = "REST Apis related to Loan Entity!!!!")
public class LoanController {

	@Autowired
	LoanService service;
	
	@ApiOperation(value = "Get list of all loans from the database ", response = Iterable.class, tags = "getLoans")
	@RequestMapping(value="/get/loanList", method=RequestMethod.GET)
	@ResponseBody
	public List<Loan> getLoans() {
		System.out.println(this.getClass().getSimpleName() + " - Get all loans service is invoked.");
		List<Loan> loanList = new ArrayList<Loan>(); 
		try {
			loanList = service.getLoans();;
	    }
	    catch (Exception ex) {
	      ex.getStackTrace();
	    }
		return loanList;
	}
	
	@GetMapping(value= "/get/loan/{id}")
	public Loan getLoanById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get loan details by id is invoked.");
	
		Optional<Loan> loan =  service.getLoanById(id);
		if(!loan.isPresent())
			throw new Exception("Could not find loan with id- " + id);
		try {
			loan = service.getLoanById(id);
	    }
	    catch (Exception ex) {
	      ex.getStackTrace();
	    }
		return loan.get();
	}
	
	@PostMapping(value= "/add/loan")
	public String createLoan(@RequestBody Loan loan) {
		System.out.println(this.getClass().getSimpleName() + " - Create new loan method is invoked.");
	try {
			service.addNewLoan(loan);
	} catch (Exception ex) {
	      return ex.getMessage();
	}
	return "Successfully inserted a row into the database!\n Row id: "+loan.getLoanNumber();
	}
	
	@ApiOperation(value = "Add all loans from one source ", response = Iterable.class, tags = "createLoans")
	@RequestMapping(value="/add/loanList", method=RequestMethod.POST)
	@ResponseBody
	public String createLoans(@RequestBody List<Loan> loanList) {
		System.out.println(this.getClass().getSimpleName() + " - Create new loan method is invoked.");
		for(Loan loan:loanList)
			System.out.println(loan);
		int recordCount = loanList.size();
		try {
				service.addNewLoanList(loanList);
		} catch (Exception ex) {
		      return ex.getMessage();
		}
		
		return "Successfully inserted rows into the database!\nRecords Inserted= "+recordCount;
	}
}
