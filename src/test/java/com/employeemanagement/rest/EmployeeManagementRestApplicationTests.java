package com.employeemanagement.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.employeemanagement.api.EmployeeController;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class EmployeeManagementRestApplicationTests {

	@InjectMocks
	private EmployeeController employeeController;
	@Mock
	private EmployeeRepository employeeRepository;

	@Test
	@DisplayName("Test size of employee list")
	public void getAllEmployeesTest() {
		when(employeeRepository.findAll()).thenReturn(Stream
				.of(new Employee("Mitadru", "Banik", "mitadrubanik@gmail.com", null, 12),
						new Employee("Rohit", "Mahajan", "rohitmahajan@gmail.com", null, 12))
				.collect(Collectors.toList()));
		assertEquals(2, employeeController.getAllEmployees().size());
	}
}
