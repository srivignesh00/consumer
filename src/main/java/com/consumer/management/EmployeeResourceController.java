package com.consumer.management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/management")
public class EmployeeResourceController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping
	public String saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	@GetMapping
	public List<Employee> getEmployee()
	{
		return employeeService.getEmployee();
	}
}
