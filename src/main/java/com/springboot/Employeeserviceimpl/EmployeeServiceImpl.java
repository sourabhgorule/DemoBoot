package com.springboot.Employeeserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.springboot.Service.EmployeeService;
import com.springboot.exception.ResourceNotFound;
import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeRepository em;
	
	
	public EmployeeServiceImpl(EmployeeRepository em) {
		super();
		this.em = em;
	}


	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return em.save(emp);
	}


	@Override
	public List<Employee> getAllemployees() {
		// TODO Auto-generated method stub
		return em.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> e=em.findById(id);
//		
//		if(e.isPresent()) {
//			return e.get();
//		}
//		else {
//			throw new ResourceNotFound("employee", "id",id);
//		}
		
		
		// Lambda function
		return em.findById(id).orElseThrow(()->new ResourceNotFound("Employee", "id", id));
	}


	@Override
	public Employee updateEmployee(Employee emp, long id) {
		// we need to check whether employee with given id is exist or not
		 Employee existing_emp= em.findById(id).orElseThrow(
				()-> new ResourceNotFound("Employee", "id", id)
				);
		
		 existing_emp.setName(emp.getName());
		 existing_emp.setEmail(emp.getEmail());
		 
		 em.save(existing_emp);
		 
		return existing_emp;
	}


	@Override
	public void deleteEmployee(long id) {
	
		//ckeck whether employee exist or not
		 em.findById(id).orElseThrow(()->new ResourceNotFound("employee", "id", id));
		
		em.deleteById(id);
		
	}

}
