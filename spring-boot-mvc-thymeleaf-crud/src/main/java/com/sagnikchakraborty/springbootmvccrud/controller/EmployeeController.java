package com.sagnikchakraborty.springbootmvccrud.controller;

import com.sagnikchakraborty.springbootmvccrud.entity.Employee;
import com.sagnikchakraborty.springbootmvccrud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // Add mapping to get a list of employees
    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/employees-list";
    }

    // Add mapping for displaying new employee create form
    @GetMapping("/addOrUpdateForm")
    public String getEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    // Add mapping for creating new employee
    @PostMapping("/save")
    public String saveEmployee(
            @ModelAttribute("employee") Employee employee) {
        // Save employee
        employeeService.save(employee);
        // Use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    // Add mapping for displaying new employee create form
    @GetMapping("/updateForm")
    public String getUpdateEmployeeForm(@RequestParam("employeeId") int id,
                                        Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    // Add mapping for deleting an employee
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
