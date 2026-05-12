package com.example.javafinalproject.Services;

import com.example.javafinalproject.DTOs.JumagulovRolanStudentDTO;
import com.example.javafinalproject.Entities.JumagulovRolanCourse;
import com.example.javafinalproject.Entities.JumagulovRolanEnroll;
import com.example.javafinalproject.Entities.JumagulovRolanStudent;
import com.example.javafinalproject.Mappers.JumagulovRolanStudentMapper;
import com.example.javafinalproject.Repositories.JumagulovRolanCourseRepository;
import com.example.javafinalproject.Repositories.JumagulovRolanEnrollRepository;
import com.example.javafinalproject.Repositories.JumagulovRolanStudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JumagulovRolanStudentService {
    private final JumagulovRolanStudentRepository studentRepository;
    private final JumagulovRolanStudentMapper studentMapper;
    private final JumagulovRolanCourseRepository courseRepository;
    private final JumagulovRolanEnrollRepository enrollRepository;


    public JumagulovRolanStudentDTO createStudent(JumagulovRolanStudentDTO dto) {
        JumagulovRolanStudent student = studentMapper.toEntity(dto);
        JumagulovRolanStudent savedStudent = studentRepository.save(student);
        return studentMapper.toDto(savedStudent);
    }
    public JumagulovRolanStudentDTO findById(Long id) {
        return studentRepository.findById(id).map(studentMapper::toDto)
                .orElseThrow(()-> new RuntimeException("Student with ID " + id + " Not found"));

    }
    @Transactional
    public void enrollStudent(Long studentId, Long courseId) {
        JumagulovRolanStudent student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student with ID " + studentId + " Not found"));
        JumagulovRolanCourse course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course with ID " + courseId + " Not found"));

        JumagulovRolanEnroll enroll = new JumagulovRolanEnroll();
        enroll.setStudent(student);
        enroll.setCourse(course);
        enroll.setStatus("Enrolled");
        enrollRepository.save(enroll);
    }

    @Transactional
    public void deleteStudent(Long id) {
        JumagulovRolanStudent student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.delete(student);
    }
}
