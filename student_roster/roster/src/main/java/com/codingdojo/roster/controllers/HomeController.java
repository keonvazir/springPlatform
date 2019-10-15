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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.roster.models.Contact;
import com.codingdojo.roster.models.Course;
import com.codingdojo.roster.models.CourseStudent;
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
	
	@PostMapping("/dorms/create")
	public String createDorm(@Valid @ModelAttribute("dormObj") Dorm dorm, BindingResult result) {
		if(result.hasErrors()) {
			return "dorm/newDorm.jsp";
		}else {
			apiService.createNewDorm(dorm);
			return "redirect:/dorms/"+dorm.getId();
		}
	}
	
	@GetMapping("/dorms/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model) {
		Dorm dorm = apiService.getOneDorm(id);
		model.addAttribute("dorm", dorm);
		List<Student> students = apiService.allStudents();
		model.addAttribute("students", students);
		return "students/studentDorm.jsp";
	}
	
	@PostMapping("/dorms/{id}/add")
	public String addStudentToDorm(@PathVariable("id") Long dorm_id, @RequestParam("student") Long student_id, Model model) {
		Student student = apiService.findStudent(student_id);
		student.setDorm(apiService.findDorm(dorm_id));
		apiService.createStudent(student);
		return "redirect:/dorms/"+dorm_id;
			
	}
	@RequestMapping("/dorms/{student_id}/destroy/{dorm_id}")
	public String destroy(@PathVariable("student_id") Long student_id, @PathVariable("dorm_id") Long dorm_id) {
		Student student = apiService.findStudent(student_id);
		student.setDorm(null);
		apiService.createStudent(student);
		return "redirect:/dorms/"+dorm_id;
	}
	
	@GetMapping("/classes/new")
	public String showCourse(@ModelAttribute("courseObj") Course course) {
		return "courses/createCourse.jsp";
		
	}
	
	@PostMapping("/classes/create")
	public String createCourse(@Valid @ModelAttribute("courseObj") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "courses/createCourse.jsp";
		}else {
			apiService.createCourse(course);
			return "redirect:/classes/"+course.getId();
		}
		
	}
	@GetMapping("/classes/{course_id}")
	public String showStudentTakingCourse(@PathVariable("course_id") Long course_id, Model model) {
		Course course = apiService.getOneCourse(course_id);
		model.addAttribute("course", course);
		List<Student> students = apiService.allStudents();
		model.addAttribute("students", students);
		return "courses/showCourse.jsp";
		
	}
	@GetMapping("/students/{student_id}")
	public String showStudentToCourse(@PathVariable("student_id") Long student_id, Model model, @ModelAttribute("middleTableObj") CourseStudent courseStudent) {
		Student student = apiService.getOneStudent(student_id);
		List<Course> courses = apiService.allCourses();
		model.addAttribute("courses", courses);
		model.addAttribute("student", student);
		
		return "courses/addStudentToCourse.jsp";
	}
	
	@PostMapping("/students/{student_id}/add")
	public String addStudentToCourse(@PathVariable("student_id") Long student_id, @RequestParam("course") Long course_id, Model model) {
		Course course = apiService.findCourse(course_id);
		Student student = apiService.findStudent(student_id);
		List<Course> courses = student.getCourses();
		courses.add(course);
		
		apiService.createStudent(student);
		return "redirect:/students/"+student_id;
		
	}
	@RequestMapping("/students/{student_id}/destroy/{course_id}")
	public String destroyDrop(@PathVariable("student_id") Long student_id, @PathVariable("course_id") Long course_id) {
		Course course = apiService.findCourse(course_id);
		course.setStudents(null);
		apiService.createCourse(course);
		return "redirect:/students/"+student_id;
	}
}



