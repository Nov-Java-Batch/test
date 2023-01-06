package com.cap.firstspringbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.firstspringbootapp.model.Employee;
import com.cap.firstspringbootapp.service.EmployeeService;

@RestController
@RequestMapping("usermodule")
public class TestController {
	
	
	@Autowired
	EmployeeService service;
	
	@Value("${app.name}")
	String appName;
	
	
	
	
	@RequestMapping("/hello")
	//@ResponseBody
	public String test() {
		
		System.out.println();
		
		return "Welcome to the Spring boot world";
	}
	
	@RequestMapping("/test1/{a}")
	public String test1(@PathVariable int a) {
		
		return "the value is "+a;
		
		
		
	}
	
	// -> /demo/user/hello
	
	// -> http://locathost:8181/demo/test1
	
	@RequestMapping("/test2/{firstName}/{lastName}")
	public String test2(@PathVariable String firstName, @PathVariable String lastName) {
		
		System.out.println(firstName);
		
		System.out.println(lastName);
		
		
		return "Hi "+firstName+" " + lastName; 
		
	}
	
	@GetMapping("/test3")
	//@RequestMapping("/test3")
	public String test3(@RequestParam String name1, @RequestParam int age, @RequestParam String name2) {
		
		
		return "Hi" + name1 + " " + age + " " + name2;
	}
	
	
	@GetMapping("/getEmployee/{firstName}/{lastName}/{age}/{id}")
	//@RequestMapping("/getEmployee/{firstName}/{lastName}/{age}/{id}")
	public Employee getEmployee(@PathVariable String firstName, @PathVariable String lastName, @PathVariable int age, @PathVariable int id) {
		
		
		Employee emp =  service.getEmployee(firstName, lastName, id, age);
		
	
		return emp;
		
	}
	
	@GetMapping("/getEmployee1")
	///@RequestMapping(value=  "/getEmployee1", method = RequestMethod.GET)
	public Employee getEmployee1(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam int id) {
		
		
		Employee emp = service.getEmployee(firstName, lastName, id, age);
		
		return emp;
		
	}
	
	
	//@RequestMapping(value=  "/saveEmployee", method = RequestMethod.POST)
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee emp) {
		
		
		String msg = service.saveEmployee(emp);
		
		return msg;
		
	}
	
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		
		
		return service.getAllEmployees();
		
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		
		
		
		return service.getEmployeeById(id);
		
		
	}
	
	
	@GetMapping("/getAllEmployeeByAge/{age}")
	public List<Employee> getAllEmployeeByAge(@PathVariable int age){
		
		
		return service.getALlEmployeesByAge(age);
		
	}
	
	
	@PostMapping("/saveAllEmployee")
	public String saveAllEmployee(@RequestBody List<Employee> empList) {
		
		
		String msg = service.saveAllEmployee(empList);
		
		return msg;
		
	}
	
	
	//http://localhost:8181/demoapplication/usermodule/saveAllEmployee
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		
		
		return service.deleteEmployeeById(id);
		
		
		
	}
	
	
	@PutMapping("/updateEmplyeeById/{id}/{firstName}/{lastName}")
	public String updateEmplyeeById(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName) {
		
		
		return service.updateEmployeeById(id, firstName, lastName);
	}
	
	
	@GetMapping("/c")
	public String readPropKeys() {
		
		System.out.println(appName);
		
		
		return appName;
		
	}

}
