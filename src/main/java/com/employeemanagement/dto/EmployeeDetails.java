package com.employeemanagement.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeDetails {
	private String employeeName;
	private Integer employeeId;
	private List<Integer> assetId;
}
