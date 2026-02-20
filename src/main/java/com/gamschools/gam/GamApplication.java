package com.gamschools.gam;

import com.gamschools.gam.entity.Course;
import com.gamschools.gam.entity.Instructor;
import com.gamschools.gam.entity.InstructorDetail;
import com.gamschools.gam.service.CourseService;
import com.gamschools.gam.service.InstructorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GamApplication {

	private final InstructorService instructorService;
	private final CourseService courseService;

	public GamApplication(InstructorService instructorService, CourseService courseService) {
		this.instructorService = instructorService;
        this.courseService = courseService;
    }

	public static void main(String[] args) {
		SpringApplication.run(GamApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
//			createInstructor();
//			deleteInstructor(7);
//			findInstructor(5);

			createCourses();
		};
	}

	private void createCourses() {
		Instructor i = instructorService.findInstructorByJoinFetch(1);
		if (i != null) {
			Course c = new Course("riazi");
			Course c1 = new Course("olum");
			i.add(c);
			i.add(c1);
			instructorService.save(i);
		}
	}

	public void createInstructor() {
		Instructor tempInstructor = new Instructor("ali", "ahmadi", "ali@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("channel_1", "football");
		tempInstructor.setInstructorDetail(instructorDetail);
		instructorService.save(tempInstructor);
	}

	public void deleteInstructor(int instructorId) {
		instructorService.delete(instructorId);
	}

	public void findInstructor(int id) {
		Instructor i = instructorService.findInstructorByJoinFetch(id);
		System.out.println(i);
		System.out.println("Courses: " + i.getCourses());
	}

}
