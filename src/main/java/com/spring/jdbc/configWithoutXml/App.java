package com.spring.jdbc.configWithoutXml;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.jdbc.dao.StudentDao;
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
        ApplicationContext context = new AnnotationConfigApplicationContext("com/spring/jdbc/configWithoutXml/JdbcConfig.java");
        StudentDao stuDao = context.getBean("studentDao",StudentDao.class);
        
//        inserting new data
        Student st= new Student(11,"chanel", "usa");
        int result = stuDao.insert(st);
        System.out.println("Student added: "+result);
    }
}
