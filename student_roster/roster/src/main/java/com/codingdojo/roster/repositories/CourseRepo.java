package com.codingdojo.roster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.roster.models.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long>{

}
