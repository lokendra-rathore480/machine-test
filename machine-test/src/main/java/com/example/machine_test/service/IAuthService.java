package com.example.machine_test.service;

import com.example.machine_test.dto.request.JwtRequestDTO;
import com.example.machine_test.dto.request.UserRequestDTO;
import com.example.machine_test.dto.response.JwtResponseDTO;
import com.example.machine_test.dto.response.UserResponseDTO;

public interface IAuthService {

    JwtResponseDTO login(JwtRequestDTO request);

    UserResponseDTO register(UserRequestDTO request);
}
