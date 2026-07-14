package com.example.machine_test.service;

import com.example.machine_test.constant.ApplicationConstant;
import com.example.machine_test.dto.request.JwtRequestDTO;
import com.example.machine_test.dto.request.UserRequestDTO;
import com.example.machine_test.dto.response.JwtResponseDTO;
import com.example.machine_test.dto.response.UserResponseDTO;
import com.example.machine_test.entity.Role;
import com.example.machine_test.entity.User;
import com.example.machine_test.entity.UserRole;
import com.example.machine_test.exception.AlreadyExistException;
import com.example.machine_test.exception.ResourceNotFoundException;
import com.example.machine_test.mapper.UserMapper;
import com.example.machine_test.repository.RoleRepository;
import com.example.machine_test.repository.UserRepository;
import com.example.machine_test.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements IAuthService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;


    @Override
    public JwtResponseDTO login(JwtRequestDTO request) {
        log.info("login method got called with username : {} and password : {}",request.getUsername(), request.getPassword());
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationConstant.USER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new RuntimeException(ApplicationConstant.INVALID_CREDENTIALS);
        String token = jwtService.generateToken(user.getUsername());
        JwtResponseDTO responseDTO = new JwtResponseDTO();
        responseDTO.setToken(token);
        responseDTO.setUsername(user.getUsername());
        return responseDTO;
    }

    @Override
    public UserResponseDTO register(UserRequestDTO request) {
        log.info("register method got called with username : {} and password : {}",request.getUsername(), request.getPassword());
        boolean exists = userRepository.existsByEmailAndUsername(request.getEmail(), request.getUsername());
        if(exists)
            throw new AlreadyExistException(ApplicationConstant.USER_ALREADY_EXIST);
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        List<UserRole> userRoleList = new ArrayList<>();
        if(request.getRoles() != null && !request.getRoles().isEmpty()){
            request.getRoles().forEach(roleDTO -> {
                UserRole userRole = new UserRole();
                Role role = null;
                //default customer role if role is not exist
                if(roleDTO.getRoleName()==null){
                    role = roleRepository.findByRoleNameIgnoreCase(ApplicationConstant.CUSTOMER)
                            .orElseThrow(() -> new ResourceNotFoundException(ApplicationConstant.ROLE_NOT_FOUND));
                    userRole.setUser(user);
                    userRole.setRole(role);
                }else{
                    role = roleRepository.findByRoleNameIgnoreCase(roleDTO.getRoleName())
                            .orElseThrow(() -> new ResourceNotFoundException(ApplicationConstant.ROLE_NOT_FOUND));
                    userRole.setUser(user);
                    userRole.setRole(role);
                }
                userRoleList.add(userRole);
            });
        }
        user.setUserRoleList(userRoleList);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }
}
