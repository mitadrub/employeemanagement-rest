package com.employeemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "assigned_asset")
public class Assigned_Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serial_no;
	@Column(name = "employee_id")
	private Integer employeeId;
	@Column(name = "assigned_asset_id")
	private String assignedAsseyee_id;

}
