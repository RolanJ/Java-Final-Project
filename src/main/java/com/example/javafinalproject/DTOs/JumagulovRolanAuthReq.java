package com.example.javafinalproject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JumagulovRolanAuthReq {
    private String login;
    private String password;
}
