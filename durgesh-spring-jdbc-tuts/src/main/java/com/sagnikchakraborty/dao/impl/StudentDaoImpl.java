package com.sagnikchakraborty.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sagnikchakraborty.dao.IStudentDao;
import com.sagnikchakraborty.entity.Student;

@Repository("studentDao")
public class StudentDaoImpl implements IStudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(Student student) {
        // Create Query
        String query = "INSERT INTO student(id, name, city) VALUES(?, ?, ?)";

        // Fire Query
        int result = jdbcTemplate.update(query, student.getId(), student.getName(),
                student.getCity());

        return result;
    }

    public int update(Student student) {
        // Create query
        String query = "UPDATE student SET name = ?, city = ? WHERE id = ?";

        // Fire query
        int result = jdbcTemplate.update(query, student.getName(), student.getCity(),
                student.getId());

        return result;
    }

    public int delete(int studentId) {
        // Create query
        String query = "DELETE FROM student WHERE id = ?";

        // Fire query
        int result = jdbcTemplate.update(query, studentId);

        return result;
    }

    public Student getStudent(int studentId) {
        // Prepare query to retrieve single student
        String query = "SELECT * FROM student WHERE id = ?";

        // Fire query and get data
        // RowMapper<Student> rowMapper = new StudentRowMapper();
        RowMapper<Student> rowMapperLambda = (rs, rowNum) -> {
				Student student = new Student();
		        student.setId(rs.getInt(1));
		        student.setName(rs.getString(2));
		        student.setCity(rs.getString(3));
		        return student;
		};
		
        Student student = null;
        try {
            student = jdbcTemplate.queryForObject(query, rowMapperLambda, studentId);
        } catch (DataAccessException e) {
            System.out.println("Exception occurred!");
        }

        return student;
    }

    public List<Student> getAllStudents() {
        // Prepare query to retrieve all students
        String query = "SELECT * FROM student";

        // Fire query and get data
        List<Student> students = null;
        try {
            students = jdbcTemplate.query(query, new StudentRowMapper());
        } catch (DataAccessException e) {
            System.out.println("Exception occurred!");
        }

        return students;
    }
}
