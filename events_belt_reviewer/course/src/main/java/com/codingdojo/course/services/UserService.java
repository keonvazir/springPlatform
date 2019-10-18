package com.codingdojo.course.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.course.models.Course;
import com.codingdojo.course.models.User;
import com.codingdojo.course.repositories.CourseRepository;
import com.codingdojo.course.repositories.UserRepository;



@Service
public class UserService {
    private final UserRepository userRepository;
    private final CourseRepository courseRepo;
    
    public UserService(UserRepository userRepository, CourseRepository courseRepo) {
        this.userRepository = userRepository;
        this.courseRepo = courseRepo;
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
    public List<User> allUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
    public List<Course> allCourses() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}
    public User getOneUser(Long user_id) {
		// TODO Auto-generated method stub
		return userRepository.findById(user_id).orElse(null);
	}
    
    public Course findEvent(Long course_id) {
		// TODO Auto-generated method stub
		return courseRepo.findById(course_id).orElse(null);
	}

	public Course createNewCourse(@Valid Course course) {
		// TODO Auto-generated method stub
		return courseRepo.save(course);
		
	}

	public Course findCourse(Long course_id) {
		// TODO Auto-generated method stub
		return courseRepo.findById(course_id).orElse(null);
	}

	public Course updateCourse(@Valid Course course) {
		// TODO Auto-generated method stub
		return this.courseRepo.save(course);
		
	}
	

	public void updateUser(User attendee) {
		// TODO Auto-generated method stub
		userRepository.save(attendee);
	}

	public void deleteCourse(Long course_id) {
		// TODO Auto-generated method stub
		courseRepo.deleteById(course_id);
		
	}

	

	public User findUser(Long user_id) {
		// TODO Auto-generated method stub
		return userRepository.findById(user_id).orElse(null);
	}

	public User updateNewUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


}

