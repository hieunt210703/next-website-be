package com.next_website_be.Entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment extends Base {
    private String trackingNumber;
    private String carrier;
    private Date shippedDate;
    private String status;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

