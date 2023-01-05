package com.cap.firstspringbootapp.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cap.firstspringbootapp.entity.Student;
import com.cap.firstspringbootapp.service.StudentService;

@RestController
public class StudentController {
	
	
	@Autowired
	StudentService service;
	
	@PostMapping("/saveStudent")
	public String saveStudent(@RequestBody Student std) {
		
		return service.saveStudent(std);
		
	}
	
	
	@PostMapping("/saveAllStudents")
	public String saveAllStudents(@RequestBody List<Student> students) {
		
		
		
		return service.saveAllStudents(students);
		
		
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		
		
		return service.getAllStudents();
	}
	
	@GetMapping("/getStudentById")
	public Student getStudentById(@RequestParam int id) {
		
		
		return service.getStudentById(id);
		
	}
	
	@GetMapping("/getAllStudentsByFirstName/{firstName}")
	public List<Student> getAllStudentsByFirstName(@PathVariable String firstName){
		
		return service.getAllStudentsByFirstName(firstName);
		
		
	}
	
	
	@GetMapping("/getAllStudentsByLastName/{lastName}")
	public List<Student> getAllStudentsByLastName(@PathVariable String lastName){
		
		return service.getAllStudentsByLastName(lastName);
		
		
	}
	
	@GetMapping("/isExist/{id}")
	public String isExist(@PathVariable int id){
		
		boolean flag = service.isExist(id);
		
		
		if(flag) {
			
			return "Given studnet id " + id + "is Available";
		}
		
		else {
			return "Given studnet id " + id + "Not is Available";
			
		}
		
	}
	
	
	@DeleteMapping("/deleteByid/{id}")
	public String deleteByid(@PathVariable int id){
		
		
		try {
			
			return service.deleteById(id);
			
		}
		
		
		catch (Exception e) {
			
			e.printStackTrace();
			
			System.out.println(e.getMessage());
			
			return "Student is deleted Successfully Id is not available : "+id;
		}
		
		
		
	}
	
	@PutMapping("/updateStudentyId")
	public String updateStudentyId(@RequestBody Student std) {
		
		
		return service.updateStudentById(std);
	}
	
	
	@GetMapping("/getAllStudentsByFAndL/{firstName}/{lastName}")
	public List<Student> getAllStudentsByFAndL(@PathVariable String firstName, @PathVariable String lastName){
		
		
		return service.getAllStudentsByFAndL(firstName, lastName);
		
	}
	
	@GetMapping("/getAllStudentsByFOrL/{firstName}/{lastName}")
	public List<Student> getAllStudentsByFOrL(@PathVariable String firstName, @PathVariable String lastName){
		
		
		return service.getAllStudentsByFOrL(firstName, lastName);
		
	}
	
	@GetMapping("/getAllStudentsByFirstNameContain/{firstName}")
	public List<Student> getAllStudentsByFirstNameContain(@PathVariable String firstName){
		
		return service.getAllStudentsByFirstNameContain(firstName);
		
	}
	
	@PostMapping("/getAllStudentsByNamesIn")
	public List<Student> getAllStudentsByNamesIn(@RequestBody List<String> names){
		
		return service.getAllStudentsByNames(names);
		
		
	}
	
	@GetMapping("/fetchAllStudentsByFirstName/{firstName}")
	public List<Student> fetchAllStudentsByFirstName(@PathVariable String firstName){
		
		
		return service.fetchStudentsByFirstName(firstName);
		
	}
	
	@GetMapping("/getAllStudentsByFirstNameWithAge/{firstName}/{age}")
	public List<Student> getAllStudentsByFirstNameWithAge(@PathVariable String firstName, @PathVariable int age){
		
		return service.getAllStudentsByFirstNameWithAge(firstName, age);
		
	}

}
