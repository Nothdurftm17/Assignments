package com.codingdojo.savetravels.services;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;
import java.util.List;
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
//	Method to create expense:
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
}
