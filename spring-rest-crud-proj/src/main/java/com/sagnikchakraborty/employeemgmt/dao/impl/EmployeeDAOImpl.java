package com.sagnikchakraborty.employeemgmt.dao.impl;

import com.sagnikchakraborty.employeemgmt.dao.IEmployeeDAO;
import com.sagnikchakraborty.employeemgmt.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee save(Employee employee) {
        // If employee id is 0 then merge method will do a INSERT query.
        // And if employee id not 0 then merge method will do an UPDATE query.
        // !!! This might not be expected behaviour always though... !!!
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
