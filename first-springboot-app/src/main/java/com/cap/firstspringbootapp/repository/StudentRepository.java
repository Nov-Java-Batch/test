package com.cap.firstspringbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.firstspringbootapp.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByFirstName(String firstName);
	
	
	List<Student> findBylastName(String lastName);
	
	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameContaining(String firstName);
	
	List<Student> findByFirstNameIn(List<String> names);
	
	List<Student> findByAgeGreaterThan(int age);
	
	List<Student> findByAgeLessThan(int age);
	
	List<Student> findByAgeBetween(int startAge, int endAge);
	
	
	@Query("SELECT s FROM Student s WHERE s.firstName = :firstName")
	List<Student> getAllStudentsByFirstName(String firstName);
	
	
	// SELCT FIRST_NAME, LAST_NAME FROM STUDENT_TT WHERE FIRST_NAME = '';
	
	@Query("SELECT s FROM Student s WHERE s.firstName LIKE %:firstName% AND s.age > :age")
	List<Student> getAllStudentsByFirstNameWithAge(String firstName, int age);
	
	

}
