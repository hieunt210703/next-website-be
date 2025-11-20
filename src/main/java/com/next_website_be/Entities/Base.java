package com.next_website_be.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
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
}
