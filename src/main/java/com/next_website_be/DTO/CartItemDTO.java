package com.next_website_be.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Integer id;
    private Integer cartId;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Double price;
}
