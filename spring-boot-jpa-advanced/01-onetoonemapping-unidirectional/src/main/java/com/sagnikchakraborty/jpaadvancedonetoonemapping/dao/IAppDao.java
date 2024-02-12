package com.sagnikchakraborty.jpaadvancedonetoonemapping.dao;

import com.sagnikchakraborty.jpaadvancedonetoonemapping.entity.Instructor;

public interface IAppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
