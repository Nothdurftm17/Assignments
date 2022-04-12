package com.codingdojo.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("/omikuji")
	public String dashboard() {
		
		return "Dashboard.jsp";
	}
	
	@RequestMapping(value="/omikuji/show", method=RequestMethod.POST)
	public String yourOmi(@RequestParam(value="number")int number, @RequestParam(value="city")String city, @RequestParam(value="person")String person, @RequestParam(value="hobby")String hobby, @RequestParam(value="living")String living, @RequestParam(value="nice")String nice, Model model) {
		
		model.addAttribute("numberToJSP", number );
		model.addAttribute("cityToJSP", city );
		model.addAttribute("personToJSP", person );
		model.addAttribute("hobbyToJSP", hobby );
		model.addAttribute("livingToJSP", living );
		model.addAttribute("niceToJSP", nice );
		
		return "YourOmi.jsp";
	}
	
	@RequestMapping("/goback")
		public String goBack(HttpSession session) {
		session.invalidate();
			return"redirect:/omikuji";
		}

}
