package com.codingdojo.roster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.roster.models.Contact;
import com.codingdojo.roster.models.Student;
import com.codingdojo.roster.services.ApiService;

@Controller
public class HomeController {
	@Autowired
	public ApiService apiService;
	
	@GetMapping("/students")
	public String showStudent(@ModelAttribute("student") Student student, Model model) {
		List<Student> students = apiService.allStudents();
		model.addAttribute("students", students);
		return "/students/show.jsp";
	}
	@GetMapping("/students/new")
	public String newStudent(Model model) {
		Student student = new Student();
		model.addAttribute("studentObj", student);
		return "/students/new.jsp";
	}
	@PostMapping("/students/new")
	public String createStudent(@Valid @ModelAttribute("studentObj") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "/students/new.jsp";
		}
		else {
			apiService.createStudent(student);
			return "redirect:/students";
		}
	}
	
	
	@GetMapping("/contact/new")
	public String showContact(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contactObj", contact);
		List<Student> students = apiService.allStudents();
		model.addAttribute("students", students);
		return "/students/contact.jsp";
	}
	
	@PostMapping("/contact/new")
	public String createContact(@Valid @ModelAttribute("contactObj") Contact contact, BindingResult result) {
		if(result.hasErrors()) {
			return "/students/contact.jsp";
		}
		else {
			apiService.createContact(contact);
			return "redirect:/students";
		}
	}

}
