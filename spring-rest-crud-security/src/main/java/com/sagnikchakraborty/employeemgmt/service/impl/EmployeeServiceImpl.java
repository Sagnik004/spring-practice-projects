package com.sagnikchakraborty.employeemgmt.service.impl;

import com.sagnikchakraborty.employeemgmt.dao.IEmployeeRepository;
import com.sagnikchakraborty.employeemgmt.entity.Employee;
import com.sagnikchakraborty.employeemgmt.exceptions.EmployeeNotFoundException;
import com.sagnikchakraborty.employeemgmt.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> res = employeeRepository.findById(id);
        Employee emp = null;
        if (res.isPresent()) {
            emp = res.get();
        } else {
            throw new EmployeeNotFoundException("Employee with id = " +
                    id + " not found");
        }
        return emp;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
