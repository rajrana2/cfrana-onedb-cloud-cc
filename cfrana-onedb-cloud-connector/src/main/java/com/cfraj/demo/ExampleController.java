package com.cfraj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

	private final JdbcTemplate jdbc;

	

	@Autowired
	public ExampleController(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
		
	}

	@RequestMapping("/")
	public String hello() {
		return jdbc.queryForObject("select first_name from employees where emp_no = 1", String.class);
	}



}
