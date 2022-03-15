package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Service.EmployeeService;
import com.springboot.model.Employee;

@RestController
@RequestMapping("/empp")
public class EmployeeController {

	@Autowired
	private EmployeeService es;

	public EmployeeController(EmployeeService es) {
		super();
		this.es = es;
	}
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		
		return new ResponseEntity<Employee>(es.saveEmployee(emp),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAll() {
		return es.getAllemployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		
		return new ResponseEntity<Employee>(es.getEmployeeById(id),HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee emp){
		return new ResponseEntity<Employee>(es.updateEmployee(emp, id),HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id ) {
		
		 es.deleteEmployee(id);
		 
		 return new ResponseEntity<String>("employee deleted successfully",HttpStatus.OK);
	}
	
	
	
}
