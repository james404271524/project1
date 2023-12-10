package com.example.demo.service;

import com.example.demo.vo.employee;

public interface employeeService {
		void addEmployee(employee e);
		employee Login(String username,String password);
		boolean UsernameRepeat(String username);
		
}
