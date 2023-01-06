package com.cap.firstspringbootapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.firstspringbootapp.entity.Student;
import com.cap.firstspringbootapp.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public String saveStudent(Student std) {

		repository.save(std);

		// repository.sa

		return "Studen is added successfully";

	}

	public String saveAllStudents(List<Student> students) {

		repository.saveAll(students);

		return "List of Students added Successfully";

	}

	public List<Student> getAllStudents() {

		return repository.findAll();
	}

	public Student getStudentById(int id) {

		return repository.findById(id).get();

	}

	public List<Student> getAllStudentsByFirstName(String firstName) {

		return repository.findByFirstName(firstName);
	}

	public List<Student> getAllStudentsByLastName(String lastName) {

		return repository.findBylastName(lastName);

	}

	public boolean isExist(int id) {

		return repository.existsById(id);

	}

	public String deleteById(int id) {

		repository.deleteById(id);

		// repository.dele

		return "Student is deleted Successfully Id is : " + id;
	}

	public String updateStudentById(Student std) {

		// Student student = repository.findById(std.getId()).get();

		// student.setFirstName(std.getFirstName());
		// student.setLastName(std.getLastName());
		// student.setAge(std.getAge());
		// student.setLastName(std.getLastName());

		repository.save(std);

		return "Student updated Successfully";

	}

	public List<Student> getAllStudentsByFAndL(String firstName, String lastName) {

		return repository.findByFirstNameAndLastName(firstName, lastName);

	}

	public List<Student> getAllStudentsByFOrL(String firstName, String lastName) {

		return repository.findByFirstNameOrLastName(firstName, lastName);

	}
	
	public List<Student> getAllStudentsByFirstNameContain(String firstName){
		
		
		return repository.findByFirstNameContaining(firstName);
	}
	
	public List<Student> getAllStudentsByNames(List<String> names){
		
		
		return repository.findByFirstNameIn(names);
	}
	
	
	public List<Student> fetchStudentsByFirstName(String firstName){
		
		
		return repository.getAllStudentsByFirstName(firstName);
	}
	
	
	public List<Student> getAllStudentsByFirstNameWithAge(String firstName, int age){
		
		return repository.getAllStudentsByFirstNameWithAge(firstName, age);
	}

}
