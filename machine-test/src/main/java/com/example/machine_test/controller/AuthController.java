package com.example.machine_test.controller;

import com.example.machine_test.dto.request.JwtRequestDTO;
import com.example.machine_test.dto.request.UserRequestDTO;
import com.example.machine_test.dto.response.JwtResponseDTO;
import com.example.machine_test.dto.response.UserResponseDTO;
import com.example.machine_test.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody JwtRequestDTO request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO request){
        return ResponseEntity.ok(authService.register(request));
    }
}
