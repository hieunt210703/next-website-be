package com.next_website_be.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer id;
    private Integer userId;
    private  Integer paymentId;
    private Integer addressId;
    private String status;
    private Double totalAmount;
    private LocalDateTime createdAt;
}
