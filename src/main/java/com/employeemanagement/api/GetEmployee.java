package com.employeemanagement.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.dab.FetchEmployeeDab;
import com.employeemanagement.dto.EmployeeDetails;

@RestController
@RequestMapping("/api/")
public class GetEmployee {

	@Autowired
	private FetchEmployeeDab fetchEmployeeDab;

	@GetMapping("/employee")
	public List<EmployeeDetails> getAllEmployees() {
		List<EmployeeDetails> listOfAsset = new ArrayList<>();
		listOfAsset = fetchEmployeeDab.fetchEmployeeDetails();
		return listOfAsset;
	}
}
