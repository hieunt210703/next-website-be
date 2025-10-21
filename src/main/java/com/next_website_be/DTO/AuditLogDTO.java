package com.next_website_be.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogDTO {

    private String userId;
    private String username;
    private String action;
    private String details;
    private String ipAddress;
    private LocalDateTime timestamp;
}
