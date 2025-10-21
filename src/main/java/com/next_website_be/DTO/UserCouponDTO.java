package com.next_website_be.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCouponDTO {
    private Integer id;
    private Integer userId;
    private Integer couponId;
    private String couponCode;
    private Boolean used;
    private LocalDateTime usedAt;
}
