package com.example.machine_test.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDTO {

    private String message;
    private HttpStatus status;
    private LocalDateTime timestamps;

    public ErrorResponseDTO(){}

    public ErrorResponseDTO(String message, HttpStatus status){
        this.message=message;
        this.status=status;
        this.timestamps= LocalDateTime.now();
    }
}
