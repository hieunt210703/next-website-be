package com.next_website_be.ApiResponse.Error_Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        return ResponseEntity.status(status).body(body);
    }

    // 404 - Not Found
    @ExceptionHandler(ApiException.ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFound(ApiException.ResourceNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    // 400 - Bad Request
    @ExceptionHandler(ApiException.AlreadyDeletedException.class)
    public ResponseEntity<Map<String, Object>> handleAlreadyDeleted(ApiException.AlreadyDeletedException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    // 409 - Conflict
//    @ExceptionHandler(ApiException.AlreadyExistsException.class)
//    public ResponseEntity<Map<String, Object>> handleAlreadyExists(ApiException.AlreadyExistsException ex) {
//        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
//    }

    // Fallback cho các exception khác
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}
