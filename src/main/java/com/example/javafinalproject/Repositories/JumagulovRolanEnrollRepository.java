package com.example.javafinalproject.Repositories;

import com.example.javafinalproject.Entities.JumagulovRolanEnroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JumagulovRolanEnrollRepository extends JpaRepository<JumagulovRolanEnroll, Long> {
}
