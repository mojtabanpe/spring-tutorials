package com.gamschools.gam.service;

import com.gamschools.gam.dao.InstructorRepository;
import com.gamschools.gam.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    public void delete(int instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    public Instructor findById(int id) {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        return instructor.orElse(null);
    }
}
