package com.next_website_be.Entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String method;  // e.g., CREDIT_CARD, MOMO, CASH
    private String status;
    private Double amount;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

