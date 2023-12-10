package com.example.demo.vo;

import lombok.Data;

@Data
public class employee {
		private Integer id;
		private String name;
		private String username;
		private String password;
		private Integer type;
		public employee(String name, String username, String password, Integer type) {
			super();
			this.name = name;
			this.username = username;
			this.password = password;
			this.type = type;
		}
		public employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
