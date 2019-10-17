package com.codingdojo.event.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.event.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAll();
    
    @Query("SELECT d FROM User d WHERE id = ?1")
    List<User> getUserWhereId(Long id);
    
}
