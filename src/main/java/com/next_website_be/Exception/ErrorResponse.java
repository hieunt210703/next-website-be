package com.next_website_be.Exception;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {
    private  LocalDateTime timestamp;
    private  int status;
    private  String error;
    private  String message;
    private  String path;
}

