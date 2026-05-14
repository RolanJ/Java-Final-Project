package com.example.javafinalproject.Repositories;

import com.example.javafinalproject.Entities.JumagulovRolanStudent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JumagulovRolanStudentRepository extends JpaRepository<JumagulovRolanStudent, Long> {
    Page<JumagulovRolanStudent> findByName(String name, Pageable pageable);

}
