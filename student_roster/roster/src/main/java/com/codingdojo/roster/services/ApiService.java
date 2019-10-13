package com.codingdojo.roster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.roster.models.Contact;
import com.codingdojo.roster.models.Student;
import com.codingdojo.roster.repositories.ContactRepo;
import com.codingdojo.roster.repositories.StudentRepo;

@Service
public class ApiService {

	
private final StudentRepo studentRepo;
private final ContactRepo contactRepo;

@Autowired
private ApiService(StudentRepo studentRepo, ContactRepo contactRepo) {
	this.studentRepo = studentRepo;
	this.contactRepo = contactRepo;
}

	public List<Student> allStudents() {
		
		return studentRepo.findAll();
	}
	
	public Student createStudent(Student s) {
		return studentRepo.save(s);
		
	}
	
	public Optional<Contact> getStudentContact(long contact_id){
		return contactRepo.findById(contact_id);
	}


	public List<Contact> allContacts() {
		
		return contactRepo.findAll();
	}

	public Contact createContact(Contact c) {
		return contactRepo.save(c);		
	}
	
}
