package com.example.machine_test.dto.response;

import com.example.machine_test.dto.RoleDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private List<RoleDTO> roles;
}
