package com.next_website_be.Entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Base {
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @PreUpdate
    public void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
    
    @PreRemove
    public void onDelete() {
        deletedAt = LocalDateTime.now();
    }
}
