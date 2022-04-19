package com.codingdojo.belt.services;

import org.springframework.stereotype.Service;

import com.codingdojo.belt.models.Plant;
import com.codingdojo.belt.repositories.PlantRepository;
import java.util.List;
import java.util.Optional;
@Service
public class PlantService {

//===========================Inject REPO================
	
	private final PlantRepository plantRepo;

public PlantService(PlantRepository plantRepo) {
	super();
	this.plantRepo = plantRepo;
}
	
//=====================FIND ALL PLANTS==================
	public List<Plant> allPlants(){
		return plantRepo.findAll();		
	}
//=====================CREATE PLANT=====================
	public Plant createPlant(Plant plant) {
		return plantRepo.save(plant);
	}
//=====================ONE PLANT========================
	public Plant findPlant(Long id) {
		Optional<Plant> optPlant = plantRepo.findById(id);
		
		if(optPlant.isPresent()) {
			return optPlant.get();
		}
		
		else {
			return null;
		}
	}
//=====================UPDATE PLANT=====================
	public Plant updatePlant(Plant plant) {
		return plantRepo.save(plant);
	}
//=====================DELETE PLANT=====================
	public void deletePlant(Long id) {	
		plantRepo.deleteById(id);
	}
}
