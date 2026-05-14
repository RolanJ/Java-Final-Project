package com.example.javafinalproject.Controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@Slf4j
@RequestMapping("/api/files")
public class JumagulovRolanFileController {
    private final String uploadDir = "uploads/";

    @PostMapping("/upload")
    public ResponseEntity<String> UploadFile(@RequestParam("file") MultipartFile file) {
        try{
            File directory = new File(uploadDir);
            if (!directory.exists()) directory.mkdir();
        }

    }

}
