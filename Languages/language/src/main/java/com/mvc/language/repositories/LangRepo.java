package com.mvc.language.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mvc.language.models.Lang;
import org.springframework.stereotype.Repository;

@Repository
public interface LangRepo extends CrudRepository<Lang, Long>{
	List<Lang> findAll();
	List<Lang> findByNameContaining(String search);
	Long countByCreatorContaining(String search);
	Long deleteByCreatorStartingWith(String search);
}
