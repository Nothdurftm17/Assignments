package com.codingdojo.dojosninjas.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
//	Inject the Repository(s)
	
	private final NinjaRepository ninjaRepo;

	public NinjaService(NinjaRepository ninjaRepo) {
		super();
		this.ninjaRepo = ninjaRepo;
	}
//=================================================================
// Method to create Ninja:
	
	public Ninja createNinja(Ninja ninja){
		return ninjaRepo.save(ninja);
  }
}
