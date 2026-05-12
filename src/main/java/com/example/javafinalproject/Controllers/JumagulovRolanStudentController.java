package com.example.javafinalproject.Controllers;

import com.example.javafinalproject.DTOs.JumagulovRolanStudentDTO;
import com.example.javafinalproject.Repositories.JumagulovRolanStudentRepository;
import com.example.javafinalproject.Services.JumagulovRolanStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistenceUnitMetadataImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class JumagulovRolanStudentController {
    private final JumagulovRolanStudentService studentService;
    private final JumagulovRolanStudentRepository studentRepository;

    @GetMapping("/{id}")
    public JumagulovRolanStudentDTO findById(@PathVariable Long id){
        log.debug("Searching for user with Id" + id);
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JumagulovRolanStudentDTO createStudent(@Valid @RequestBody JumagulovRolanStudentDTO dto) {
        log.info("Created student");
        return studentService.createStudent(dto);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        log.info("Deleted student");

    }
}
