package com.sagnikchakraborty.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DataConfig {
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	@Value("${spring.datasource.username}")
	private String dbUsername;
	
	@Value("${spring.datasource.password}")
	private String dbPassword;

	@Bean
	DataSource dataSource() {
		/* Default Hikari connection pool */
//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setJdbcUrl(dbUrl);
//		dataSource.setUsername(dbUsername);
//		dataSource.setPassword(dbPassword);
//		return dataSource;
		
		/* C3P0 connection pool */
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		
		pooledDataSource.setJdbcUrl(dbUrl);
		pooledDataSource.setUser(dbUsername);
		pooledDataSource.setPassword(dbPassword);
		
		return pooledDataSource;
	}

    @Bean
    JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
