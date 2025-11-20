package com.next_website_be.DTO.Request;

import com.next_website_be.DTO.ProductImageDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private String name;
    private String description;
    private Double price;
    private String brandId;
    private String categoryId;
    private List<ProductImageDTO> images;
}