package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.countries.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();
	@Query("SELECT d.language from Country d")
	List<String> findAllLanguages();

}
