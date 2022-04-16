package com.codingdojo.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class HomeControllers {
	
//	Import the service and generate/update constructor to initiate the service.
	
private final ExpenseService expenseServ;
	
	
public HomeControllers(ExpenseService expenseServ) {
	super();
	this.expenseServ = expenseServ;
}


//	==============ROUTE TO MAIN PAGE (ADD MODEL model IF NEEDED)============
@GetMapping("/")
public String expense(@ModelAttribute("expense") Expense expense, Model model) {
	model.addAttribute("allExpenses", expenseServ.allExpenses());
	return "expenses.jsp";
}
	
//	==============ROUTE TO PROCESS POST METHOD (CREATE EXPENSE)===============
@PostMapping("/processExpense")
public String postingExpense(@Valid @ModelAttribute("expense")Expense expense, BindingResult result) {
	if(result.hasErrors()) {
		return"expenses.jsp";
	} else {
		expenseServ.createExpense(expense);
		return"redirect:/";
	}
	
}

}
