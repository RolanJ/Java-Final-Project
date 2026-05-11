package com.example.javafinalproject.Services;

import com.example.javafinalproject.DTOs.JumagulovRolanStudentDTO;
import com.example.javafinalproject.Entities.JumagulovRolanStudent;
import com.example.javafinalproject.Mappers.JumagulovRolanStudentMapper;
import com.example.javafinalproject.Repositories.JumagulovRolanStudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JumagulovRolanStudentService {
    private final JumagulovRolanStudentRepository studentRepository;
    private final JumagulovRolanStudentMapper studentMapper;

    public JumagulovRolanStudentDTO createStudent(JumagulovRolanStudentDTO dto) {
        JumagulovRolanStudent student = studentMapper.toEntity(dto);
        JumagulovRolanStudent savedStudent = studentRepository.save(student);
        return studentMapper.toDto(savedStudent);
    }
    @Transactional
    public void deleteStudent(Long id) {
        JumagulovRolanStudent student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.delete(student);
    }
}
