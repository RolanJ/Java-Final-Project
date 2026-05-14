package com.example.javafinalproject.Controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        String filePath = uploadDir + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        log.info("File uploaded");
        return ResponseEntity.ok("File uploaded successfully");
    } catch (IOException e) {
        return ResponseEntity.status(500).body("Could not upload file");
    }
}
    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Path path = Paths.get(uploadDir).resolve(filename);
        Resource resource = new FileSystemResource(path);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
