package com.codingdojo.roster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.roster.models.CourseStudent;

@Repository
public interface CourseStudentRepo extends CrudRepository<CourseStudent, Long>{

}
