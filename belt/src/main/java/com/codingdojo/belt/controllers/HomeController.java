package com.codingdojo.belt.controllers;

import javax.servlet.http.HttpSession;
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

import com.codingdojo.belt.models.LoginUser;
import com.codingdojo.belt.models.Plant;
import com.codingdojo.belt.models.User;
import com.codingdojo.belt.services.PlantService;
import com.codingdojo.belt.services.UserService;

@Controller
public class HomeController {
	
//=================================Import Services========================================
	private final UserService userServ;
	private final PlantService plantServ;
	public HomeController(UserService userServ, PlantService plantServ) {
		super();
		this.userServ = userServ;
		this.plantServ = plantServ;
	}
//=============================ROUTE TO RENDER LOGIN/REG PAGE===================
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    
    }
//=============================ROUTE TO PROCESS REG POST =======================    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
          
        // No errors! 
       
        session.setAttribute("user_id",userServ.register(newUser, result).getId());
        
        return "redirect:/dashboard";
    }
//============================ROUTE TO PROCESS LOGIN POST =======================
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }
//============================ROUTE TO LOGOUT======================================    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return"redirect:/";
    }

    
//============================PLANT ROUTES=========================================   

    
    
//============================RENDER DASHBOARD PAGE================================    
    
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null) {
			model.addAttribute("user",userServ.oneUser((Long)session.getAttribute("user_id")));
			model.addAttribute("allPlants", plantServ.allPlants());
			return"dashboard.jsp";	
		}
		
		return"redirect:/";
	} 
//============================RENDER CREATE PAGE===================================
    @GetMapping("/plants/new")
    public String createPlant(@ModelAttribute("plant") Plant plant) {
    	
    	return "newPlant.jsp";  	
    }
    
//============================ROUTE TO PROCESS CREATE POST========================
	@PostMapping("/processPlant")
	public String postingPlant(@Valid @ModelAttribute("plant") Plant plant, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return"newPlant.jsp";
		}
		
		User user= userServ.oneUser((Long)session.getAttribute("user_id"));
		plant.setUser(user);
		plantServ.createPlant(plant);
		return"redirect:/dashboard";
	}
	
//============================RENDER UPDATE PAGE===================================
    @GetMapping("/plants/edit/{id}")
    public String updatePLant(@PathVariable("id") Long id, @ModelAttribute("plant") Plant plant, Model model) {
    	model.addAttribute("plant", plantServ.findPlant(id));
    	return"editPlant.jsp";
    }
    
//============================ROUTE TO PROCESS UPDATE POST========================= 
    @RequestMapping(value="/updatingPlant/{id}", method=RequestMethod.PUT)
    public String updatingPlant(@Valid @ModelAttribute("plant") Plant plant, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "editPlant.jsp";
    	} else {
    		User user= userServ.oneUser((Long)session.getAttribute("user_id"));
    		plant.setUser(user);
    		plantServ.updatePlant(plant);
    		return "redirect:/dashboard";
    	}
    }
	
//============================RENDER SHOW ONE PAGE=================================  
	@GetMapping("/onePlant/{id}")
	public String onePlant(@PathVariable("id")Long id, Model model) {
		model.addAttribute("plant", plantServ.findPlant(id));
		return"showOne.jsp";
	}

//============================ROUTE TO DELETE PLANT========================= 
	@GetMapping("/deletePlant/{id}")
	public String deletePlant(@PathVariable("id")Long id) {
		plantServ.deletePlant(id);
		
		return"redirect:/dashboard";		
	}
    
    
    
    
    
    
    
    
    
}