package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.repositories.LookifyRepo;




@Service
public class LookifyService {
private final LookifyRepo lookifyRepository;
    
    public LookifyService(LookifyRepo lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }
	public List<Lookify> allSongs() {
        return lookifyRepository.findAll();
    }
    // creates a book
    public Lookify createSong(Lookify b) {
        return lookifyRepository.save(b);
    }
    // retrieves a book
    public Lookify findBook(Long id) {
        Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
        if(optionalLookify.isPresent()) {
            return optionalLookify.get();
        } else {
            return null;
        }
    }

}
