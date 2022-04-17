package com.codingdojo.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

//==============ROUTE TO RENDER SHOW ONE PAGE ================================
//Requires @PathVariable, Model model
@GetMapping("/oneExpense/{id}")
public String oneExpense(@PathVariable("id") Long id, Model model) {
	model.addAttribute("expense", expenseServ.findExpense(id));
	return"oneExpense.jsp";
}

//=====================ROUTE TO RENDER UPDATE PAGE============================
//Requires a Model model, @PathVariable, @ModelAttribute as parameters
//Requires a findOne method
@GetMapping("/updateExpense/{id}")
public String updateExpenseForm(@PathVariable("id") Long id, @ModelAttribute("expense") Expense expense, Model model) {
	model.addAttribute("expense", expenseServ.findExpense(id));
	return"updateExpense.jsp";
}
//=====================ROUTE TO PROCESS UPDATE PUT============================
@RequestMapping(value="/updatingExpense/{id}", method=RequestMethod.PUT)
public String updatingExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	if(result.hasErrors()) {
		return "updateExpense.jsp";
	} else {
		expenseServ.updateExpense(expense);
		return "redirect:/";
	}
}
//=================ROUTE TO DELETE AN EXPENSE=================================
@GetMapping("/delete/{id}")
public String delete(@PathVariable("id") Long id) {
	expenseServ.delete(id);
	return"redirect:/";
}
	

}
