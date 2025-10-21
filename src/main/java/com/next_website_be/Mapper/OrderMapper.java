package com.next_website_be.Mapper;

import com.next_website_be.DTO.OrderDTO;
import com.next_website_be.Entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "paymentId", source = "payment.id")
    OrderDTO toDTO(Order entity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "payment", ignore = true)
    Order toEntity(OrderDTO dto);
}
