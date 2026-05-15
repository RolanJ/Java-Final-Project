package com.example.javafinalproject.Repositories;

import com.example.javafinalproject.Entities.JumagulovRolanUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JumagulovRolanUserRepository extends JpaRepository<JumagulovRolanUser, Long> {
    Optional<JumagulovRolanUser> findByLogin(String login);
}
