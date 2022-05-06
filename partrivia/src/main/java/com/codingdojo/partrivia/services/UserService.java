package com.codingdojo.partrivia.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.partrivia.models.LoginUser;
import com.codingdojo.partrivia.models.User;
import com.codingdojo.partrivia.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
   
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
    	
//    	=========Reject if email is already taken=================================================================
    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email", "Unique", "You cannot use this email, already taken!");
    	}
    	
//    	=========Reject if passwords don't match===================================================================
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "Your passwords do not match!");
    	}
    	
    	
//    	=========return  null if result has errors================================================================
    	if (result.hasErrors()) {
    		return null;
    	}
    	
    	
//      =========hash and set password, saver user to database==========================================================
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	
        return userRepo.save(newUser);
    }
    
//  =====================LOGIN================================================================================  
    public User login(LoginUser newLogin, BindingResult result) {
        // TO-DO: Additional validations!
    	
    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Unique","Invalid Email");
    		return null;
    	}
    	User user = potentialUser.get();
    	
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid Password");
    		return null;
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	} else {
    		return user;
    	}
    }
//  ==========================================================================================================  
//    OneUser: 
  	public User oneUser(Long id) {
  		Optional<User> optionalUser = userRepo.findById(id);
  		if(optionalUser.isPresent()) {
  			return optionalUser.get();
  		} else {
  			return null;
  		}
  	}
//  	=======================================================================================================
  	public List<User> allUsers() {
  		return userRepo.findAll();
  	}
}

