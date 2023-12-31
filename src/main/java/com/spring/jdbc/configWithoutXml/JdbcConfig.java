package com.spring.jdbc.configWithoutXml;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.jdbc.dao.StudentDao;
import com.spring.jdbc.jdbc.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {
	
	@Bean(name={"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds =  new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}
	
	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean(name={"studentDao"})
	public StudentDao getStudentDao() {
		StudentDaoImpl dao = new StudentDaoImpl();
		dao.setJdbcTemplate(getTemplate());
		return dao;
	}
}
