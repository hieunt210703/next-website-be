package com.next_website_be.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductImageDTO {
    private Integer id;
    private String imageUrl;
    private Boolean isMain;
    private Integer productId;
}
