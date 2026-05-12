package com.example.javafinalproject.Repositories;

import com.example.javafinalproject.Entities.JumagulovRolanCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JumagulovRolanCourseRepository extends JpaRepository<JumagulovRolanCourse, Long> {
}
