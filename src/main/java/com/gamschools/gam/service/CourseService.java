package com.gamschools.gam.service;

import com.gamschools.gam.dao.CourseRepository;
import com.gamschools.gam.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(int id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public void deleteById(int id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        }
    }
}
