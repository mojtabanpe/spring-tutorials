package com.gamschools.gam;

import com.gamschools.gam.entity.Instructor;
import com.gamschools.gam.entity.InstructorDetail;
import com.gamschools.gam.service.InstructorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GamApplication {

	private final InstructorService instructorService;

	public GamApplication(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GamApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
//			createInstructor();
//			deleteInstructor(7);
			findInstructor(5);
		};
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
		Instructor i = instructorService.findById(id);
		System.out.println(i);
	}

}
