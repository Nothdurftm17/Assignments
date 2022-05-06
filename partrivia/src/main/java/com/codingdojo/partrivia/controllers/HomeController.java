package com.codingdojo.partrivia.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.partrivia.models.LoginUser;
import com.codingdojo.partrivia.models.User;
import com.codingdojo.partrivia.services.UserService;

@Controller
public class HomeController {
//	
//	String q1 = " Question: What’s the diameter of a basketball hoop in inches?";
//	String q1a1 = "20 inches";
//	String q1a2c = "18 inches";
//	String q1a3 = "16 inches";
//	String q1a4 = "19 inches";
//
//	
//	String q2 = " Question: The Olympics are held every how many years? ";
//	String q2a1 = "1";
//	String q2a2 = "3";
//	String q2a3c = "4";
//	String q2a4 = "2";
//	
//	String q3 = " Question: What sport is best known as the ‘king of sports’?";
//	String q3a1c = "Soccer";
//	String q3a2 = "Basketball";
//	String q3a3 = "Baseball";
//	String q3a4 = "Football";
//	
	String q1 = " Question: What do you call it when a bowler makes three strikes in a row?";
	String q1a1 = "Gobble";
	String q1a2 = "Rooster";
	String q1a3 = "Triple Strikes";
	String q1a4c = "Turkey";
	
	String q2 = " Question: What’s the national sport of Canada?";
	String q2a1c = "Lacrosse";
	String q2a2 = "Hockey";
	String q2a3 = "Golf";
	String q2a4 = "Squash";
	
	String q3 = "Question: How many dimples does an average golf ball have?";
	String q3a1c = "336";
	String q3a2 = "400";
	String q3a3 = "325";
	String q3a4 = "531";
	
//=================================Import Services===============================
	private final UserService userServ;

	
	public HomeController(UserService userServ) {
		super();
		this.userServ = userServ;
	}

//=============================ROUTE TO RENDER LOGIN/REG PAGE===================
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "logAndReg.jsp";
    
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
            return "logAndReg.jsp";
        }
          
        // No errors! 
       
        session.setAttribute("user_id",userServ.register(newUser, result).getId());
        
        return "redirect:/home";
    }
//============================ROUTE TO PROCESS LOGIN POST =======================
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "logAndReg.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        return "redirect:/home";
    }
//============================ROUTE TO LOGOUT======================================    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return"redirect:/";
    }

 //============================RENDER HOME PAGE================================    
    
  	@GetMapping("/home")
  	public String dashboard(Model model, HttpSession session) {
  		if(session.getAttribute("user_id") != null) {
  			model.addAttribute("user",userServ.oneUser((Long)session.getAttribute("user_id")));
  			model.addAttribute("allUsers", userServ.allUsers());
//  			model.addAttribute("makeJoin", new Join());
  			return"home.jsp";	
  		}
  		
  		return"redirect:/";
  	} 
  	
//===========================RENDER STARTER PAGE================================
  	@GetMapping("/starter")
  	public String starter(Model model, HttpSession session) {
  		if(session.getAttribute("user_id") != null) {
  			model.addAttribute("user",userServ.oneUser((Long)session.getAttribute("user_id")));
//  			model.addAttribute("allUsers", userServ.allUsers());
//  			model.addAttribute("makeJoin", new Join());
  			session.setAttribute( "correctCount", 0);
  			session.setAttribute( "ansLeft", 3);
  			return"getStarted.jsp";	
  		}
  		
  		return"redirect:/";
  	} 
  	
	
//===========================RENDER holeOne PAGE================================
@GetMapping("/holeOne")
public String holeOne(Model model, HttpSession session) {
	if(session.getAttribute("user_id") != null) {
		
		

		model.addAttribute("cCount",session.getAttribute( "correctCount"));
		model.addAttribute("aLeft",session.getAttribute( "ansLeft"));
		
		
		model.addAttribute("user",userServ.oneUser((Long)session.getAttribute("user_id")));
		model.addAttribute("questionOne",q1);
		model.addAttribute("answerOne",q1a1);
		model.addAttribute("answerTwo",q1a2);
		model.addAttribute("answerThree",q1a3);
		model.addAttribute("answerFour",q1a4c);
		return"holeOne.jsp";	
	}
	
	return"redirect:/";
} 


@GetMapping("/holeTwo")
public String holeTwo(Model model, HttpSession session) {
	if(session.getAttribute("user_id") != null) {
		
		
		model.addAttribute("cCount",session.getAttribute( "correctCount"));
		model.addAttribute("aLeft",session.getAttribute( "ansLeft"));
		
		model.addAttribute("user",userServ.oneUser((Long)session.getAttribute("user_id")));
		model.addAttribute("questionTwo",q2);
		model.addAttribute("answerOne",q2a1c);
		model.addAttribute("answerTwo",q2a2);
		model.addAttribute("answerThree",q2a3);
		model.addAttribute("answerFour",q2a4);
		return "holeTwo.jsp";	
	}
	
	return"redirect:/";
} 

//=============================================================================

@GetMapping("/holeThree")
public String holeThree(Model model, HttpSession session) {
	if(session.getAttribute("user_id") != null) {
		
		
		model.addAttribute("cCount",session.getAttribute( "correctCount"));
		model.addAttribute("aLeft",session.getAttribute( "ansLeft"));
		
		model.addAttribute("user",userServ.oneUser((Long)session.getAttribute("user_id")));
		model.addAttribute("questionThree",q3);
		model.addAttribute("answerOne",q3a1c);
		model.addAttribute("answerTwo",q3a2);
		model.addAttribute("answerThree",q3a3);
		model.addAttribute("answerFour",q3a4);
		return "holeThree.jsp";	
	}
	
	return"redirect:/";
} 

//=============================================================================

@GetMapping("/results")
public String results(Model model, HttpSession session) {
	if(session.getAttribute("user_id") != null) {
		
		model.addAttribute("cCount",session.getAttribute( "correctCount"));
		model.addAttribute("aLeft",session.getAttribute( "ansLeft"));
		
		model.addAttribute("user",userServ.oneUser((Long)session.getAttribute("user_id")));
		return "results.jsp";	
	}
	
	return"redirect:/";
} 

//=============================================================================

@PostMapping("/check")
public String check(@RequestParam(value = "answer") String answer, HttpSession session, RedirectAttributes flash) {
	if(answer.equals("Correct")) {
		flash.addFlashAttribute("success", "You selected the correct answer!!");
		Integer correctCount = (Integer)session.getAttribute("correctCount");
		correctCount+=1;
		session.setAttribute("correctCount", correctCount);
		Integer ansLeft = (Integer) session.getAttribute("ansLeft");
		ansLeft-=1;
		session.setAttribute("ansLeft", ansLeft);
		return "redirect:/holeTwo";
		
	} else {
		flash.addFlashAttribute("wrong", "Incorrect answer! Make it up on the next hole!");
		session.getAttribute("correctCount");
		Integer ansLeft = (Integer) session.getAttribute("ansLeft");
		ansLeft-=1;
		session.setAttribute("ansLeft", ansLeft);
		
		return "redirect:/holeTwo";
	}
	
}

//=============================================================================
@PostMapping("/checkTwo")
public String checkTwo(@RequestParam(value = "answer") String answer, HttpSession session, RedirectAttributes flash) {
	if(answer.equals("Correct")) {
		flash.addFlashAttribute("success", "You selected the correct answer!!");
		Integer correctCount = (Integer)session.getAttribute("correctCount");
		correctCount+=1;
		session.setAttribute("correctCount", correctCount);
		Integer ansLeft = (Integer) session.getAttribute("ansLeft");
		ansLeft-=1;
		session.setAttribute("ansLeft", ansLeft);
		return "redirect:/holeThree";
		
	} else {
		flash.addFlashAttribute("wrong", "Incorrect answer! Make it up on the next hole!");
		session.getAttribute("correctCount");
		Integer ansLeft = (Integer) session.getAttribute("ansLeft");
		ansLeft-=1;
		session.setAttribute("ansLeft", ansLeft);
		return "redirect:/holeThree";
	}
	
}

@PostMapping("/checkThree")
public String checkThree(@RequestParam(value = "answer") String answer, HttpSession session, RedirectAttributes flash) {
	if(answer.equals("Correct")) {
		flash.addFlashAttribute("success", "You selected the correct answer!!");
		Integer correctCount = (Integer)session.getAttribute("correctCount");
		correctCount+=1;
		session.setAttribute("correctCount", correctCount);
		Integer ansLeft = (Integer) session.getAttribute("ansLeft");
		ansLeft-=1;
		session.setAttribute("ansLeft", ansLeft);
		return "redirect:/results";
		
	} else {
		flash.addFlashAttribute("wrong", "Incorrect answer! Make it up on the next hole!");
		session.getAttribute("correctCount");
		Integer ansLeft = (Integer) session.getAttribute("ansLeft");
		ansLeft-=1;
		session.setAttribute("ansLeft", ansLeft);
		return "redirect:/results";
	}
	
}



}


