package com.sagnikchakraborty.jpaadvancedonetoonemapping;

import com.sagnikchakraborty.jpaadvancedonetoonemapping.dao.IAppDao;
import com.sagnikchakraborty.jpaadvancedonetoonemapping.entity.Instructor;
import com.sagnikchakraborty.jpaadvancedonetoonemapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaadvancedonetoonemappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaadvancedonetoonemappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(IAppDao appDao) {
		return runner -> {
			// createInstructor(appDao);
			// findInstructor(appDao);
			// deleteInstructor(appDao);

			// findInstructorDetail(appDao);
			deleteInstructorDetail(appDao);
		};
	}

	private void deleteInstructorDetail(IAppDao appDao) {
		int id = 1;
		System.out.println("Deleting instructor detail with id: " + id);
		System.out.println("This will not delete the associated instructor " +
				"as we explicitly specified the cascading types and broke the" +
				"bidirectional link");
		appDao.deleteInstructorDetailById(id);
		System.out.println("Instructor detail only deleted!");
	}

	private void findInstructorDetail(IAppDao appDao) {
		int id = 2;
		System.out.println("Finding instructor detail with id: " + id);
		System.out.println("It will also eagerly retrieve associated instructor " +
				"due to one-to-one bidirectional mapping and cascade effect");
		InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(IAppDao appDao) {
		int id = 1;
		System.out.println("Deleting instructor with id: " + id + ". It will also delete " +
				"associated instructor details due to one-to-one cascade effect");
		appDao.deleteInstructorById(id);
		System.out.println("Instructor and associated details deleted!");
	}

	private void findInstructor(IAppDao appDao) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id + ". It will also eagerly " +
				"retrieve associated instructor details due to one-to-one cascade effect");
		Instructor instructor = appDao.findInstructorById(id);
		System.out.println(instructor);
	}

	private void createInstructor(IAppDao appDao) {
		Instructor instructor1 = new Instructor(
				"Ram", "Singh", "ram_singh@gmail.com");
		InstructorDetail instructorDetail1 = new InstructorDetail(
				"AllJava", "Playing guitar");
		instructor1.setInstructorDetail(instructorDetail1);
		appDao.save(instructor1);

		Instructor instructor2 = new Instructor(
				"Kalki", "Upadhay", "kalki0209@yahoo.com");
		InstructorDetail instructorDetail2 = new InstructorDetail(
				"Healthy Yoga", "Painting");
		instructor2.setInstructorDetail(instructorDetail2);
		appDao.save(instructor2);

		System.out.println("Instructors saved successfully along with instructor details!");
	}
}
