package com.example.machine_test.mapper;

import com.example.machine_test.dto.RoleDTO;
import com.example.machine_test.dto.request.UserRequestDTO;
import com.example.machine_test.dto.response.UserResponseDTO;
import com.example.machine_test.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO request){

        if(request==null)
            return null;
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        return user;
    }

    public UserResponseDTO toDTO(User user){

        if(user==null)
            return null;

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setFirstName(user.getFirstName());
        responseDTO.setLastName(user.getLastName());
        responseDTO.setUsername(user.getUsername());
        responseDTO.setEmail(user.getEmail());
        //don't response the password for the security purpose
        List<RoleDTO> roleDTOList = new ArrayList<>();
        if (user.getUserRoleList() != null) {
            user.getUserRoleList().forEach(userRole -> {
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setId(userRole.getRole().getId());
                roleDTO.setRoleName(userRole.getRole().getRoleName());
                roleDTOList.add(roleDTO);
            });
        }
        responseDTO.setRoles(roleDTOList);
        return responseDTO;
    }
}
