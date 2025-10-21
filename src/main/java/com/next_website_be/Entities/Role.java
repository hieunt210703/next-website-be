package com.next_website_be.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends Base{
    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 500)
    private String description;
}
