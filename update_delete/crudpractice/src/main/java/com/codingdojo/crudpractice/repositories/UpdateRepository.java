package com.codingdojo.crudpractice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.crudpractice.models.Update;


@Repository
public interface UpdateRepository extends CrudRepository<Update, Long> {
	List<Update> findAll();
	
	List<Update> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
	
//    Long countByTitleContaining(String search);
// 
//    Long updateByTitleStartingWith(String search);
//    
//    Long deleteByTitleStartingWith(String search);

}
