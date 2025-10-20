package com.next_website_be.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "coupons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String code;

    private String description;

    @Column(nullable = false)
    private BigDecimal discountAmount; // hoặc discountPercentage nếu muốn % giảm

    private Boolean percentage; // true = giảm theo %, false = giảm tiền cố định

    private LocalDate startDate;
    private LocalDate endDate;

    private Integer usageLimit; // số lần được dùng tối đa
    private Boolean active;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL)
    private List<UserCoupon> userCoupons;
}
