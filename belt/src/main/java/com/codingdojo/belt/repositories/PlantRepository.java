package com.codingdojo.belt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.belt.models.Plant;

import java.util.List;
@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
	List<Plant> findAll();
}
