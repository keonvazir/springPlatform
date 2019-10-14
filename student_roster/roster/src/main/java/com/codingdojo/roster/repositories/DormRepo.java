package com.codingdojo.roster.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.roster.models.Dorm;

@Repository
public interface DormRepo extends CrudRepository<Dorm, Long>{

}
