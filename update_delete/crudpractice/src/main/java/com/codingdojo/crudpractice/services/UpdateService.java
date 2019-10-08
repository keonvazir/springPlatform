package com.codingdojo.crudpractice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.crudpractice.models.Update;
import com.codingdojo.crudpractice.repositories.UpdateRepository;


@Service
public class UpdateService {
	@Autowired
	public UpdateRepository crudRepository;
    // adding the book repository as a dependency
    
    // returns all the books
    public List<Update> getAllBooks() {
        return crudRepository.findAll();
    }
    // creates a book
    public Update createBook(Update u) {
        return crudRepository.save(u);
    }
    // retrieves a book
    public Update findBook(Long id) {
        Optional<Update> optionalUpdate = crudRepository.findById(id);
        if(optionalUpdate.isPresent()) {
            return optionalUpdate.get();
        } else {
            return null;
        }
    }
	public Update update(Long id, String title, String desc, String lang, Integer numOfPages) {
		// TODO Auto-generated method stub
		Update new_book = findBook(id);
		if(new_book == null) {
            return null;
        } 
		new_book.setTitle(title);
		new_book.setDescription(desc);
		new_book.setLanguage(lang);
		new_book.setNumberOfPages(numOfPages);
		
		return crudRepository.save(new_book);
		
		
	}
	public void deleteUpdate(Long id) {
		// TODO Auto-generated method stub
		
		
	}
}
