package com.codingdojo.event.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.User;
import com.codingdojo.event.repositories.EventRepository;
import com.codingdojo.event.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EventRepository eventRepo;
    
    public UserService(UserRepository userRepository, EventRepository eventRepo) {
        this.userRepository = userRepository;
        this.eventRepo = eventRepo;
    }
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

	public Event createNewEvent(@Valid Event event) {
		// TODO Auto-generated method stub
		return eventRepo.save(event);
		
	}
	public User getOneUser(Long user_id) {
		// TODO Auto-generated method stub
		return userRepository.findById(user_id).orElse(null);
	}

	public List<User> allUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public List<Event> allEvents() {
		// TODO Auto-generated method stub
		return eventRepo.findAll();
	}
	
	public Event findEvent(Long event_id) {
		// TODO Auto-generated method stub
		return eventRepo.findById(event_id).orElse(null);
	}
	public List<Event> eventsInState(String state) {
		// TODO Auto-generated method stub
		return eventRepo.findByState(state);
	}
	public List<Event> eventsNotInState(String state) {
		// TODO Auto-generated method stub
		return eventRepo.findByStateNot(state);
	}

	public Event updateEvent(@Valid Event event) {
		// TODO Auto-generated method stub
		return this.eventRepo.save(event);
		
	}
	public Event getOneEvent(Long id) {
		return eventRepo.findById(id).orElse(null);
	}

	public void updateUser(User attendee) {
		// TODO Auto-generated method stub
		userRepository.save(attendee);
	}

	public void deleteEvent(Long event_id) {
		// TODO Auto-generated method stub
		eventRepo.deleteById(event_id);
		
	}


}