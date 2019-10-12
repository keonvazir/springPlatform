package com.codingdojo.roster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.roster.models.Contact;
import com.codingdojo.roster.models.Student;
import com.codingdojo.roster.repositories.StudentRepo;

@Service
public class ApiService {
@Autowired
private StudentRepo studentRepo;

	public List<Student> allStudents() {
		
		return studentRepo.findAll();
	}

	public List<Contact> allContacts() {
		
		return null;
	}

	public Student createStudent(Student student) {
		return studentRepo.save(student);
		
	}
	
}
