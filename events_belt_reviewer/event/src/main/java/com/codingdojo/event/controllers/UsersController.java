package com.codingdojo.event.controllers;

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

import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.User;
import com.codingdojo.event.services.UserService;
import com.codingdojo.event.validator.UserValidator;

@Controller
public class UsersController {
    private final UserService userService;
    private final UserValidator userValidator;
    
    private final String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID",
            "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ",
            "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
            "WY" };
    
    public UsersController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    
    @RequestMapping("/")
    public String home(@ModelAttribute("user") User user, Model model) {
    	model.addAttribute("states", states);
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
    		return "redirect:/events";
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
    
    @RequestMapping("/events")
    public String home(HttpSession session, Model model, @ModelAttribute("event") Event event) {
        // get user from session, save them in the model and return the home page
    	Long userId = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(userId);
    	model.addAttribute("user", user);
    	
    	model.addAttribute("states", states);
    	model.addAttribute("events", userService.allEvents());
    	String state = user.getState();
    	List<Event> eventsIn = userService.eventsInState(state);
    	model.addAttribute("eventsIn", eventsIn);

    	List<Event> eventsOut = userService.eventsNotInState(state);
    	model.addAttribute("eventsOut", eventsOut);

    	List<User> users = userService.allUsers();
    	model.addAttribute("users", users);
    	model.addAttribute("events", userService.allEvents());
    	return "event.jsp";
    }
    
    @PostMapping("/events/create")
    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "event.jsp";
    	} else {
    		Long userId = (Long) session.getAttribute("userId");
    		User user = userService.findUserById(userId);
    		event.setPlanner(user);
    		userService.createNewEvent(event);
    		return "redirect:/events";
    	}
    }
    
    @GetMapping("/events/{event_id}")
    public String showEvent(@PathVariable("event_id") Long event_id, Model model, HttpSession session) {
    	Event event = userService.findEvent(event_id);
    	model.addAttribute("event", event);
    	List<User> users = userService.allUsers();
    	model.addAttribute("users", users);
    	return "show.jsp";
    	
    }
    //insert post mapping for show event message wall 
    //populate name of attendees
    
    @GetMapping("/events/{event_id}/edit")
    public String editEvent(@PathVariable("event_id") Long event_id, Model model, HttpSession session) {
    	
    	Event event = userService.findEvent(event_id);
    	model.addAttribute("states", states);
    	model.addAttribute("event", event);
    	return "edit.jsp";
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("event") Event event, BindingResult result) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	} else {
    		this.userService.updateEvent(event);
    		return "redirect:/events";
    	}
    }
    
   @GetMapping("/events/{event_id}/addUser")
   public String addUserToEvent(HttpSession session, @PathVariable("event_id") Long event_id) {
	   Long userId = (Long) session.getAttribute("userId");
	   User attendee = userService.findUserById(userId);
	   Event attending_event = userService.findEvent(event_id);
	   List<User> attendees = attending_event.getAttendees();
	   attendees.add(attendee);
	   attending_event.setAttendees(attendees);
	   userService.updateUser(attendee);
//	   System.out.println("made it");
	   return "redirect:/events";
   }
   
   @GetMapping("/events/{event_id}/cancel")
   public String cancel(HttpSession session, @PathVariable("event_id") Long event_id) {
	   Long userId = (Long) session.getAttribute("userId");
	   User attendee = userService.findUserById(userId);
	   Event attending_event = userService.findEvent(event_id);
	   List<User> attendees = attending_event.getAttendees();
	   attendees.remove(attendee);
	   attending_event.setAttendees(attendees);
	   userService.updateUser(attendee);
	   return "redirect:/events";
   }
    @GetMapping("/events/{event_id}/destroy")
    public String destroy(@PathVariable("event_id") Long event_id) {
    	userService.deleteEvent(event_id);
    	return "redirect:/events";
    	
    }
}
