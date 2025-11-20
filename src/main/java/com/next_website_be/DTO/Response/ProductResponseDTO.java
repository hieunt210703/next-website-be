package com.next_website_be.DTO.Response;

import com.next_website_be.DTO.ProductImageDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private String id;
    private String name;
    private String description;
    private Double price;
    private String brandName;
    private String categoryName;
    private List<ProductImageDTO> images;
}
