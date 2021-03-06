package com.employeemanagement.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.exception.ResourceNotFoundException;
import com.employeemanagement.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(value = "http://localhost:3000")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	private Date currentDate = new Date();

	// get all employees
	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	// Create employee rest api
	@SuppressWarnings("deprecation")
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		int age = currentDate.getYear() - employee.getDateOfBirth().getYear();
		employee.setAge(age);
		return employeeRepository.save(employee);
	}

	// get employee by id
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No employee exists with id " + id));
		return ResponseEntity.ok(employee);
	}

	// update employee
	@SuppressWarnings("deprecation")
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No employee exists with id " + id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		int age = currentDate.getYear() - employeeDetails.getDateOfBirth().getYear();
		employee.setAge(age);
		return ResponseEntity.ok(employeeRepository.save(employee));

	}

	// delete employee
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No employee exists with id " + id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
