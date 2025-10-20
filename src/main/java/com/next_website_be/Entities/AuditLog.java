package com.next_website_be.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // Nếu bạn có entity User

    private String action;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String details;

    @Column(name = "ip_address")
    private String ipAddress;

    private LocalDateTime timestamp;
}
