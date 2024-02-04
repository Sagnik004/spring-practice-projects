package com.sagnikchakraborty.springbootmvccrud.dao;

import com.sagnikchakraborty.springbootmvccrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    // All basic CRUD methods are available with just extending JpaRepository

    // Add a method to sort by last name.
    // Pattern of name is important here for JPA to prepare the corresponding query for us.
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    public List<Employee> findAllByOrderByFirstNameAsc();
}
