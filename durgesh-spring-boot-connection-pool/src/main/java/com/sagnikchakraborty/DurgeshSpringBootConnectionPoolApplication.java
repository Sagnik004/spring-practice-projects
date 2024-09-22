package com.sagnikchakraborty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

// Followed: https://youtu.be/UFxA3MuGBxs

@SpringBootApplication(exclude = {
		JdbcTemplateAutoConfiguration.class,
		DataSourceAutoConfiguration.class
})
public class DurgeshSpringBootConnectionPoolApplication implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DurgeshSpringBootConnectionPoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String query = "SELECT * FROM student";
		jdbcTemplate.query(query, (rs) -> {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String city = rs.getString(3);
			System.out.println("Student details: id=" + id + ", name=" + name + ", city=" + city);
		});
	}

}
