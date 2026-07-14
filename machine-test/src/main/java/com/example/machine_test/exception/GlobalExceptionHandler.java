package com.example.machine_test.exception;

import com.example.machine_test.dto.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception ex){
        ErrorResponseDTO responseDTO = new ErrorResponseDTO();
        responseDTO.setMessage(ex.getMessage());
        responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.ok(responseDTO);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex){
        ErrorResponseDTO responseDTO = new ErrorResponseDTO();
        responseDTO.setMessage(ex.getMessage());
        responseDTO.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(responseDTO);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponseDTO> handleAlreadyExistException(AlreadyExistException ex){
        ErrorResponseDTO responseDTO = new ErrorResponseDTO();
        responseDTO.setMessage(ex.getMessage());
        responseDTO.setStatus(HttpStatus.CONFLICT);
        return ResponseEntity.ok(responseDTO);
    }


}
