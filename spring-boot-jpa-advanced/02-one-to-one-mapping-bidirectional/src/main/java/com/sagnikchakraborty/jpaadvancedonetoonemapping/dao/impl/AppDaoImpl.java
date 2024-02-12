package com.sagnikchakraborty.jpaadvancedonetoonemapping.dao.impl;

import com.sagnikchakraborty.jpaadvancedonetoonemapping.dao.IAppDao;
import com.sagnikchakraborty.jpaadvancedonetoonemapping.entity.Instructor;
import com.sagnikchakraborty.jpaadvancedonetoonemapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImpl implements IAppDao {

    private final EntityManager entityManager;

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

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        // Retrieve the instructor detail
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        // Remove the associated object reference
        // Break the bidirectional link
        instructorDetail.getInstructor().setInstructorDetail(null);

        // Delete the instructor detail (will also delete the instructor due to cascading effect)
        entityManager.remove(instructorDetail);
    }
}
