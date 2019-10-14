package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{
List<Country> findAll();

}
