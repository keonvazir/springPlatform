package com.codingdojo.event.repositories;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.event.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event> findAll();
	
	List<Event> findByState(String state);
	
	List<Event> findByStateNot(String state);
	
//	@Query("SELECT d.name from Event d WHERE id = ?1")
//    List<Event> getEventWhereId(Long id);
//}
}