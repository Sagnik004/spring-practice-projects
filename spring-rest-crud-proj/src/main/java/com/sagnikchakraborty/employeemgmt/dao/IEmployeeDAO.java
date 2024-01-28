package com.sagnikchakraborty.employeemgmt.dao;

import com.sagnikchakraborty.employeemgmt.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {

    Employee findById(int id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(int id);
}
