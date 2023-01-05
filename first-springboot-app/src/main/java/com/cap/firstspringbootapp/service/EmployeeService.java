package com.cap.firstspringbootapp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.firstspringbootapp.model.Employee;
import com.cap.firstspringbootapp.repository.StudentRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	StudentRepository repository;

	List<Employee> list = new ArrayList<>();

	public Employee getEmployee(String firstName, String lastName, int id, int age) {

		Employee emp = new Employee();

		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setAge(age);
		emp.setId(id);

		return emp;

	}

	public String saveEmployee(Employee emp) {

		list.add(emp);
		
		//repository.save(entity)

		return "Employee is added successfully " + emp.getId();

	}

	public List<Employee> getAllEmployees() {

		return list;
	}

	public Employee getEmployeeById(int id) {

		for (Employee emp : list) {

			if (emp.getId() == id) {

				return emp;
			}

		}

		return null;

	}

	public List<Employee> getALlEmployeesByAge(int age) {

		List<Employee> ageList = new ArrayList<>();

		for (Employee emp : list) {

			if (emp.getAge() > age) {

				ageList.add(emp);

			}

		}

		return ageList;

	}

	public String saveAllEmployee(List<Employee> empList) {

		
		list.addAll(empList);

		return "All Employee is added successfully ";

	}
	
	
	public String deleteEmployeeById(int id) {
		
		
		Iterator<Employee> itr = list.iterator();
		
		
		
		while(itr.hasNext()) {
			
			
			Employee emp = itr.next();
			
			if(emp.getId() == id) {
				
				itr.remove();
				
				return "Employee is deleted successfully : "+emp.getId();
			}
		}
		
		
		
		return "Employee is not found to delete";
		
	}
	
	
	
	public String updateEmployeeById(int id, String firstName, String lastName) {
		
		
		
		ListIterator<Employee>  itr = list.listIterator();
		
		
		while(itr.hasNext()) {
			
			
			Employee emp = itr.next();
			
			
			if(emp.getId() == id) {
				
				emp.setFirstName(firstName);
				emp.setLastName(lastName);
			}
			
			
		}
		
		
		
		
		return "updated successfully " + id;
	}

}
