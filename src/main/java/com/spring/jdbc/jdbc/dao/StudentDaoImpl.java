package com.spring.jdbc.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
//      insert query
      String query="insert into student(id,name,city) values(?, ?, ?)";
//    fire query
      int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
      return result;
	}

	public int change(Student student) {
	    String query="update student set name=?, city=? where id=?";
//	    fire query
	      int result = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return result;	      
	}

	public int delete(int studentId) {
	    String query="delete from student where id=?";
	    int result = this.jdbcTemplate.update(query,studentId);
		return result;
	}

}
