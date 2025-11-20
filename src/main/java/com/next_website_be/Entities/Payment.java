package com.next_website_be.Entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment extends Base {
    private String method;  // e.g., CREDIT_CARD, MOMO, CASH
    private String status;
    private Double amount;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

