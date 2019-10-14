package com.codingdojo.roster.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.roster.models.Contact;
import com.codingdojo.roster.models.Dorm;
import com.codingdojo.roster.models.Student;
import com.codingdojo.roster.repositories.ContactRepo;
import com.codingdojo.roster.repositories.DormRepo;
import com.codingdojo.roster.repositories.StudentRepo;

@Service
public class ApiService {

	
private final StudentRepo studentRepo;
private final ContactRepo contactRepo;
private final DormRepo dormRepo;

@Autowired
private ApiService(StudentRepo studentRepo, ContactRepo contactRepo, DormRepo dormRepo) {
	this.studentRepo = studentRepo;
	this.contactRepo = contactRepo;
	this.dormRepo = dormRepo;
}

	public List<Student> allStudents() {
		
		return studentRepo.findAll();
	}
	
	public Student createStudent(Student student) {
		return studentRepo.save(student);
		
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

	public Dorm createNewDorm(@Valid Dorm dorm) {
		// TODO Auto-generated method stub
		return dormRepo.save(dorm);
		
	}

	public void addStudentToDorm(@Valid Student student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
		
	}

	public Dorm getOneDorm(Long id) {
		// TODO Auto-generated method stub
		return dormRepo.findById(id).orElse(null);
	}

	public Student findStudent(Long student_id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(student_id).orElse(null);
	}

	public Dorm findDorm(Long dorm_id) {
		// TODO Auto-generated method stub
		return dormRepo.findById(dorm_id).orElse(null);
	}

	
}
