package com.sagnikchakraborty.jpaadvancedonetoonemapping.dao;

import com.sagnikchakraborty.jpaadvancedonetoonemapping.entity.Instructor;
import com.sagnikchakraborty.jpaadvancedonetoonemapping.entity.InstructorDetail;

public interface IAppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
