package com.next_website_be.Mapper;

import com.next_website_be.DTO.UserCouponDTO;
import com.next_website_be.Entities.UserCoupon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserCouponMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "couponCode", source = "coupon.code")
    UserCouponDTO toDTO(UserCoupon entity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "coupon", ignore = true)
    UserCoupon toEntity(UserCouponDTO dto);
}
