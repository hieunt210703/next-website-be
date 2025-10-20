package com.next_website_be.Entities;

import jakarta.persistence.Column;

public class UserRole extends Base {
    @Column(nullable = false, length = 50)
    private String role;
}
