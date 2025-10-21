package com.next_website_be.Mapper;

import com.next_website_be.DTO.OrderItemDTO;
import com.next_website_be.Entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(target = "productName", source = "variant.product.name")
    OrderItemDTO toDTO(OrderItem entity);

    @Mapping(target = "variant", ignore = true)
    @Mapping(target = "order", ignore = true)
    OrderItem toEntity(OrderItemDTO dto);
}
