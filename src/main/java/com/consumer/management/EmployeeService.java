package com.consumer.management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class EmployeeService {
	
	
	private RestTemplate restTemplate;
		@Autowired
		public EmployeeService(RestTemplateBuilder restTemplateBuilder) {
		
		this.restTemplate = restTemplateBuilder.build();
	}

		public String saveEmployee(Employee employee)
		{
			HttpEntity<Employee> entity = new HttpEntity<>(employee);
			return restTemplate.exchange("http://localhost:8080/api/add", HttpMethod.POST, entity, String.class).getBody();
			
		}
		
		public List<Employee> getEmployee()
		{
			return restTemplate.exchange("http://localhost:8080/api/employee",HttpMethod.GET,null,List.class).getBody();
		}
}
