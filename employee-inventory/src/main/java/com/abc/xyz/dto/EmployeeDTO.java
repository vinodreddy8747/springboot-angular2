package com.abc.xyz.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public @Data class EmployeeDTO {
	private int id;
	private String name;
	private int age;
}
