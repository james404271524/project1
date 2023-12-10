package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.impl.employeeServiceimpl;
import com.example.demo.vo.employee;


@RestController
public class employeeController {
		@Autowired
		employeeServiceimpl esi;
		
		@GetMapping("/employee")
		public ModelAndView gotoEmployeeLogin()
		{
			return new ModelAndView("/employee/employeeLogin");
		}
		
		@GetMapping("/manager")
		public ModelAndView gotoManager()
		{
			return new ModelAndView("/employee/manager");
		}
		
		@GetMapping("/addEmployee")
		public ModelAndView gotoAddEmployee()
		{
			return new ModelAndView("/employee/addEmployee");
		}
		
		@PostMapping("/employeeLogin")
		public ModelAndView gotoLogin(String username,String password)
		{
				employee e=esi.Login(username, password);
				ModelAndView mav=null;
				if(e!=null)
				{
					if(e.getType()==1)
					{
						mav=new ModelAndView("/employee/manager");
					}
					else
					{
						mav=new ModelAndView("/employee/employee");
					}
				}
				else
				{
					mav=new ModelAndView("/employee/employeeLoginError");
				}
				
				return mav;
		}
		
		@PostMapping("/addEm")
		public ModelAndView add(String name,String username,String password,int type)
		{
			boolean u=esi.UsernameRepeat(username);
			ModelAndView mav=null;
			if(u)
			{	
				mav=new ModelAndView("/employee/addEmployeeError");
			}
			else
			{
				employee e=new employee(name,username,password,type);
				esi.addEmployee(e);
				
				mav=new ModelAndView("/employee/addEmployeeSuccess");
				
			}
			
			return mav;
			
		}
	
}
