package com.next_website_be.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponDTO {
    private Integer id;
    private String code;
    private Double discount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean active;
}
