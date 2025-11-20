package com.next_website_be.DTO.Response;

import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandResponseDTO {
    private String id;        // ID của Brand (Entity có)
    private String name;      // Tên thương hiệu
    private String description; // Mô tả thương hiệu
    private String logoUrl;   // URL logo
}

