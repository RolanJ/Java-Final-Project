package com.example.javafinalproject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JumagulovRolanErrorDTO {
        private int status;
        private String message;
        private long timestamp;
}
