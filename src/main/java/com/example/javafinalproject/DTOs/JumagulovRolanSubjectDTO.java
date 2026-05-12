package com.example.javafinalproject.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JumagulovRolanSubjectDTO {
    @NotBlank
    private String name;

}
