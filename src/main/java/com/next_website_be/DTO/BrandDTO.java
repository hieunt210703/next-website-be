package com.next_website_be.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO {
    private Integer id;
    private String name;
    private String description;
}
