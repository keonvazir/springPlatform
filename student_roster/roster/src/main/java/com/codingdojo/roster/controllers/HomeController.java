package com.codingdojo.roster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.roster.models.Contact;
import com.codingdojo.roster.models.Dorm;
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
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dormObj") Dorm dorm) {
		return "dorm/newDorm.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String createDorm(@Valid @ModelAttribute("dormObj") Dorm dorm, Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "dorm/newDorm.jsp";
		}else {
			apiService.createNewDorm(dorm);
			return "redirect:/dorms/"+student.getDorm().getId();
		}
	}
	
	@GetMapping("/dorms/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model) {
		Dorm dorm = apiService.getOneDorm(id);
		model.addAttribute("dorm", dorm);
		return "students/studentDorm.jsp";
	}
	
	@PostMapping("/dorms/{id}")
	public String addStudentToDorm(@Valid @ModelAttribute("studentObj") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "students/studentDorm.jsp";
		}
		else {
			apiService.addStudentToDorm(student);
			return "redirect:/dorms/"+student.getDorm().getId();
			
		}
	}

}
