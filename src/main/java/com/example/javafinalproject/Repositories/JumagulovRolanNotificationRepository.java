package com.example.javafinalproject.Repositories;

import com.example.javafinalproject.Entities.JumagulovRolanNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JumagulovRolanNotificationRepository extends JpaRepository<JumagulovRolanNotification, Long> {
}
