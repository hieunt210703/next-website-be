package com.next_website_be.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Integer id;
    private Integer orderId;
    private String paymentMethod;
    private String transactionId;
    private String status;
    private LocalDateTime paidAt;
}
