package com.spring.jdbc.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.jdbc.dao.StudentDao;
import com.spring.jdbc.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/jdbc/config.xml");
        StudentDao stuDao = context.getBean("studentDao",StudentDao.class);
        
//        inserting new data
        Student st= new Student(7,"Lana", "usa");
        int result = stuDao.insert(st);
        System.out.println("Student added: "+result);
        
//        updating the existing data with id
        Student st2 = new Student(4,"Gagandeep", "mohali");
        int result1 = stuDao.change(st2);
        System.out.println("Student changed: "+result1);
        
//        deleting the data with id
        int result2 = stuDao.delete(6);
        System.out.println("Student deleted: "+result2);
    }
}
