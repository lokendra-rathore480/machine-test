package com.example.machine_test.dto.request;

import com.example.machine_test.dto.RoleDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private List<RoleDTO> roles;
}
