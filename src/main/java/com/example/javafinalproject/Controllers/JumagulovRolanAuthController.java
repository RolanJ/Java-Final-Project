package com.example.javafinalproject.Controllers;

import com.example.javafinalproject.DTOs.JumagulovRolanAuthReq;
import com.example.javafinalproject.JWT.JumagulovRolanJwtUtils;
import com.example.javafinalproject.Entities.JumagulovRolanUser;
import com.example.javafinalproject.Repositories.JumagulovRolanUserRepository;
import com.example.javafinalproject.JWT.JumagulovRolanRole;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
    @Slf4j
    @RestController
    @RequestMapping("/api/auth")
    public class JumagulovRolanAuthController {
        private final JumagulovRolanUserRepository userRepository;
        private final PasswordEncoder passEncoder;
        private final JumagulovRolanJwtUtils jwtUtils;

        public JumagulovRolanAuthController(JumagulovRolanUserRepository userRepository,
                                            PasswordEncoder passEncoder,
                                            JumagulovRolanJwtUtils jwtUtils) {
            this.userRepository = userRepository;
            this.passEncoder = passEncoder;
            this.jwtUtils = jwtUtils;
        }
        @Transactional
        @PostMapping("/register")
        public ResponseEntity<String> registerUser(@RequestBody JumagulovRolanAuthReq registerRequest){
            if (userRepository.findByLogin(registerRequest.getLogin()).isPresent()) {
                log.error("User already exists");
                return ResponseEntity.badRequest().body("Already exists");
            }
            JumagulovRolanUser user = JumagulovRolanUser.builder()
                    .login(registerRequest.getLogin())
                    .password(passEncoder.encode(registerRequest.getPassword()))
                    .role(JumagulovRolanRole.ROLE_USER)
                    .build();

            userRepository.save(user);
            log.info("User created");
            return ResponseEntity.ok("User created");
        }
        @Transactional
        @PostMapping("/login")
        public ResponseEntity<String> authenticateUser(@RequestBody JumagulovRolanAuthReq loginRequest) {
            Optional<JumagulovRolanUser> userOpt = userRepository.findByLogin(loginRequest.getLogin());
            if (userOpt.isPresent() && passEncoder.matches(loginRequest.getPassword(), userOpt.get().getPassword())) {
                String token = jwtUtils.generateJwtToken(loginRequest.getLogin());
                log.info("Token created");
                return ResponseEntity.ok("Bearer " + token);
            }

            return ResponseEntity.status(401).body("Incorrect data");
        }
    }
