package com.example.machine_test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponseDTO {

    private String username;
    private String token;

    public JwtResponseDTO(){}
}
