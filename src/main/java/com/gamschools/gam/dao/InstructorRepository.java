package com.gamschools.gam.dao;

import com.gamschools.gam.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    @Query("SELECT i FROM Instructor i LEFT JOIN FETCH i.courses WHERE i.id = :id")
    Optional<Instructor> findInstructorByJoinFetch(@Param("id") int id);
}
