package com.next_website_be.DTO.Request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandRequestDTO {
    private String name;
    private String description;
    private String logoUrl;
}
