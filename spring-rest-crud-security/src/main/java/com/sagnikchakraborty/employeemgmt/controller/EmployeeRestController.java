package com.sagnikchakraborty.employeemgmt.controller;

import com.sagnikchakraborty.employeemgmt.entity.Employee;
import com.sagnikchakraborty.employeemgmt.exceptions.EmployeeNotFoundException;
import com.sagnikchakraborty.employeemgmt.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeRestController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id = " +
                    employeeId + " not found");
        }
        return employee;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        // Just in case client sent an id, set it back to 0.
        // This is to enforce creating a new employee instead of updating an existing one (if found).
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id = " +
                    employeeId + " not found");
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee with id " + employeeId;
    }
}
