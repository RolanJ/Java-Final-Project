package com.example.javafinalproject.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class JumagulovRolanEnroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime enrollDate =  LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "student_id")
    private JumagulovRolanStudent student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private JumagulovRolanCourse course;
}

