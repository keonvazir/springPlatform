package com.codingdojo.roster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.roster.models.Dorm;

public interface DormRepo extends CrudRepository<Dorm, Long>{
	List<Dorm> findAll();

}
