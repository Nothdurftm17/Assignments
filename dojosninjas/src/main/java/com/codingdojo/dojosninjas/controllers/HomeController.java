package com.codingdojo.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.services.DojoService;
import com.codingdojo.dojosninjas.services.NinjaService;



@Controller
public class HomeController {

//	Import the service and generate/update constructor to initiate the service.
	
	private final DojoService dojoServ;
	private final NinjaService ninjaServ;
	public HomeController(DojoService dojoServ, NinjaService ninjaServ) {
		super();
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}
//	=============================DOJO ROUTES================================
	
//	==========ROUTE TO MAIN PAGE (ADD MODEL model IF NEEDED)================
@GetMapping("/dojos/new")
public String expense(@ModelAttribute("dojo") Dojo dojo) {
	return "dojo.jsp";
}
//==============ROUTE TO PROCESS POST METHOD (CREATE EXPENSE)===============
@PostMapping("/processDojo")
public String postingDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
if(result.hasErrors()) {
	return"dojo.jsp";
} else {
	dojoServ.createDojo(dojo);
	return"redirect:/dojos/new";
}

}
//==========ROUTE TO SHOW DOJO (ADD MODEL model for ninjas)================
@GetMapping("/dojos/{id}")
public String oneDojo(@PathVariable("id") Long id, Model model) {
	Dojo dojo = dojoServ.findDojo(id);
	model.addAttribute("dojo",dojo);
	return"showDojo.jsp";
}



//=============================NINJA ROUTES================================

//==========ROUTE TO NEW NINJA (ADD @ModelAttribute)=======================
@GetMapping("/ninjas/new")
public String expense(@ModelAttribute("ninja") Ninja ninja, Model model) {
	model.addAttribute("allDojos", dojoServ.allDojos());
	
	return "ninja.jsp";
}
//=========================================================================
@PostMapping("/processNinja")
public String postingNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {

if(result.hasErrors()) {
	model.addAttribute("allDojos", dojoServ.allDojos());
	return"ninja.jsp";
} else {
	ninjaServ.createNinja(ninja);
	return"redirect:/dojos/" + ninja.getDojo().getId();

   }
 }
//=========================================================================
}
