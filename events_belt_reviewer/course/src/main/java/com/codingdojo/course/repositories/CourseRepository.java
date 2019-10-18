package com.codingdojo.course.repositories;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.course.models.Course;



@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
	List<Course> findAll();
	
	
//	@Query("SELECT d.name from Event d WHERE id = ?1")
//  List<Event> getEventWhereId(Long id);
//}
}
