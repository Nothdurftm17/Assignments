package com.codingdojo.savetravels.services;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;
import java.util.List;
import java.util.Optional;
@Service
public class ExpenseService {
//	Inject the Repository(s)
	private final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		super();
		this.expenseRepo = expenseRepo;
	}
	
//	=================================================================
//	Method to findAll expenses:
	
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
//	=================================================================
//	Method to findOne expense:
	public Expense findExpense(Long id) {
		Optional<Expense> optExpense = expenseRepo.findById(id);
		
		if(optExpense.isPresent()) {
			return optExpense.get();
		} else {
			return null;
		}
	}
	
//	=================================================================
//	Method to create expense:
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
//	=================================================================
//	Method to delete expense: 
	public void delete(Long id) {
		 expenseRepo.deleteById(id);
		
	}
//	=================================================================
//	Method to update expense:
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
}

