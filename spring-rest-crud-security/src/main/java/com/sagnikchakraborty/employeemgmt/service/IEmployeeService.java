package com.sagnikchakraborty.employeemgmt.service;

import com.sagnikchakraborty.employeemgmt.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee findById(int id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(int id);
}
