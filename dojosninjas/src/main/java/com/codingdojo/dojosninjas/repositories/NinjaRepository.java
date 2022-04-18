package com.codingdojo.dojosninjas.repositories;

import org.springframework.stereotype.Repository;

import com.codingdojo.dojosninjas.models.Ninja;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

}
