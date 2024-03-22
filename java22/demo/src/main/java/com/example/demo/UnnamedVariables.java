package com.example.demo;

import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;

public class UnnamedVariables {

	private final JdbcClient db;

	UnnamedVariables(DataSource ds) {
		this.db = JdbcClient.create(ds);
	}

	record Customer(Integer id, String name) {
	}

	public void run() throws Throwable {
		var allCustomers = this.db.sql("select * from customer ")
			.query((rs, _) -> new Customer(rs.getInt("id"), rs.getString("name")))
			.list();

		System.out.println("all: " + allCustomers);
	}

}
