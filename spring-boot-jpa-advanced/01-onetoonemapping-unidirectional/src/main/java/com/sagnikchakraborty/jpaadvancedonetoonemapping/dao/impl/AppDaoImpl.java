package com.sagnikchakraborty.jpaadvancedonetoonemapping.dao.impl;

import com.sagnikchakraborty.jpaadvancedonetoonemapping.dao.IAppDao;
import com.sagnikchakraborty.jpaadvancedonetoonemapping.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImpl implements IAppDao {

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        // Retrieve the instructor
        Instructor instructor = entityManager.find(Instructor.class, id);

        // Delete the instructor
        entityManager.remove(instructor);
    }
}
