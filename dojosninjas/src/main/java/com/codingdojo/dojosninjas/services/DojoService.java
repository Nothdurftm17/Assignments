package com.codingdojo.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.repositories.DojoRepository;



@Service
public class DojoService {
//	Inject the Repository(s)
	
	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dojoRepo) {
		super();
		this.dojoRepo = dojoRepo;
	}
	
//	=================================================================
//	Method to findAll Dojos:
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
//	=================================================================
//	Method to create Dojo:
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
//	=================================================================
//	Method to findOne Dojo:
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optDojo = dojoRepo.findById(id);
		
		if(optDojo.isPresent()) {
			return optDojo.get();
		}
		else {
			return null;
		}
	}
}
