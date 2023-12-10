package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.employeeMapper;
import com.example.demo.service.employeeService;
import com.example.demo.vo.employee;

@Service
public class employeeServiceimpl implements employeeService{
	@Autowired
	employeeMapper em;
	
	@Override
	public void addEmployee(employee e) {
		em.add(e);
		
	}

	@Override
	public employee Login(String username, String password) {
		employee e=em.queryUser(username, password);
		
		return e;
	}

	@Override
	public boolean UsernameRepeat(String username) {
		employee e=em.queryUsername(username);
		boolean x=false;
		if(e!=null) x=true;
		
		return x;
	}

	

}
