package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.employee;

@Mapper
public interface employeeMapper {
		@Insert("insert into employee(name,username,password,type)"
				+ "values(#{name},#{username},#{password},#{type})")
		void add(employee e);
		
		@Select("select * from employee where username=#{username} and password=#{password}")
		employee queryUser(String username,String password);
		
		@Select("select * from employee where username=#{username}")
		employee queryUsername(String username);
		
		@Select("select * from employee where type=#{type}")
		employee queryType(int type);
	
}
