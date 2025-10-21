package com.next_website_be.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Base {
    @Id
    @Column(length = 36, unique = true)
    private String id;

    @PrePersist
    public void generateId() {
        if (id == null || id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private boolean isDeleted = false;
}
