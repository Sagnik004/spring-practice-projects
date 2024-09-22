package com.sagnikchakraborty;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sagnikchakraborty.config.JdbcConfig;
import com.sagnikchakraborty.dao.IStudentDao;
import com.sagnikchakraborty.entity.Student;

public class App {
	
    public static void main( String[] args ) {
        System.out.println("App started...");

        /* 
         * XML file configuration
         */
//         AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        
        /* 
         * Java and annotation based configuration
         */
        AnnotationConfigApplicationContext ctx = 
        		new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        /* 
         * Simple Example (not recommended)
         */
//        JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
//        String qry = "INSERT INTO STUDENT(id, name, city) VALUES (?, ?, ?)";
//        int count = jdbcTemplate.update(qry, 5, "Uttam Kumar", "Kolkata");
//        System.out.println("Number of record(s) inserted: " + count);
        
        IStudentDao studentDao = ctx.getBean("studentDao", IStudentDao.class);
        
        // Insert new student
//        Student student1 = new Student(7, "Fluffy", "San Jose");
//        int result = studentDao.insert(student1);
//        System.out.println(String.format("Rows inserted: %d", result));
        
        // Update existing student
//        Student student2 = new Student(5, "Uttam Kumar", "Lucknow");
//        int result = studentDao.update(student2);
//        System.out.println(String.format("Rows updated: %d", result));
        
        // Delete existing student
//        int result = studentDao.delete(5);
//        System.out.println(String.format("Rows deleted: %d", result));
        
        // Get existing student by id
//        Student fetchedStudent = studentDao.getStudent(6);
//        System.out.println(fetchedStudent);
        
        // Get all students
        List<Student> students = studentDao.getAllStudents();
        students.stream().forEach(System.out::println);

        ctx.close();
    }
}
