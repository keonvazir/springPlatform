package com.codingdojo.course.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.course.models.Course;
import com.codingdojo.course.models.User;
import com.codingdojo.course.services.UserService;
import com.codingdojo.course.validator.UserValidator;


@Controller
public class HomeController {
    private final UserService userService;
    private final UserValidator userValidator;
    
    public HomeController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    
    @RequestMapping("/")
    public String home(@ModelAttribute("user") User user, Model model) {
        return "home.jsp";
    }
    
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "home.jsp";
    	}else {
    		User u = userService.registerUser(user);
    		session.setAttribute("userId", u.getId());
    		
    		return "redirect:/";
    	}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@ModelAttribute("user") User user, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
   
    		session.setAttribute("userId", u.getId());
    		return "redirect:/courses";
    	} else {
    		model.addAttribute("error", "Invalid Credentials. Please try again.");
    		return "home.jsp";
    	}
        // else, add error messages and return the login page
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/";
    }
    @RequestMapping("/courses")
    public String home(HttpSession session, Model model, @ModelAttribute("course") Course course) {
        // get user from session, save them in the model and return the home page
    	Long userId = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(userId);
    	model.addAttribute("user", user);
    	
    	List<Course> courses = userService.allCourses();
    	model.addAttribute("courses", courses);
    	
    	

    	List<User> users = userService.allUsers();
    	model.addAttribute("users", users);
    	model.addAttribute("courses", userService.allCourses());
    	
    	return "course.jsp";
    }
    @GetMapping("/courses/new")
    public String showAddCourse(Model model, HttpSession session) {
    	Course course = new Course();
    		model.addAttribute("course", course);
    		return "new.jsp";
    	}
    
    
    @PostMapping("/course/create")
    public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "new.jsp";
    	} else {
    		Long userId = (Long) session.getAttribute("userId");
    		User user = userService.findUserById(userId);
    		course.setPlanner(user);
    		userService.createNewCourse(course);
    		return "redirect:/courses";
    	}
    }
    @GetMapping("/courses/{course_id}")
    public String showEvent(@PathVariable("course_id") Long course_id, Model model, HttpSession session) {
    	Course course = userService.findCourse(course_id);
    	model.addAttribute("course", course);
    	List<User> users = userService.allUsers();
    	model.addAttribute("users", users);
    	return "show.jsp";
    	
    }
    @GetMapping("/courses/{course_id}/edit")
    public String editEvent(@PathVariable("course_id") Long course_id, Model model, HttpSession session) {
    	
    	Course course = userService.findCourse(course_id);
    	model.addAttribute("course", course);
    	return "edit.jsp";
    }
    @RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("course") Course course, BindingResult result) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	} else {
    		this.userService.updateCourse(course);
    		return "redirect:/courses";
    	}
    }
    @GetMapping("/courses/{course_id}/add")
    public String addUserToCourse(HttpSession session, @PathVariable("course_id") Long course_id) {
 	   Long userId = (Long) session.getAttribute("userId");
 	   User attendee = userService.findUserById(userId);
 	   Course attending_course = userService.findCourse(course_id);
 	   List<User> attendees = attending_course.getAttendees();
 	   attendees.add(attendee);
 	   attending_course.setAttendees(attendees);
 	   userService.updateUser(attendee);
// 	   System.out.println("made it");
 	   return "redirect:/courses";
    }
    @GetMapping("/courses/{course_id}/destroy")
    public String destroyCourse(@PathVariable("course_id") Long course_id) {
    	userService.deleteCourse(course_id);
    	return "redirect:/courses";
    	
    }
    @RequestMapping("/courses/{course_id}/destroy/{user_id}")
    public String destroyUser(@PathVariable("user_id") Long user_id, @PathVariable("course_id") Long course_id) {
    	User user = userService.findUser(user_id);
    	user.setCoursesAttending(null);
    	userService.updateNewUser(user);
    	return "redirect:/courses/"+course_id;
    	
    }  
}