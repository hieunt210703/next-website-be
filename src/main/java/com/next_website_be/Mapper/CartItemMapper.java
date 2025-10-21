package com.next_website_be.Mapper;

import com.next_website_be.DTO.CartItemDTO;
import com.next_website_be.Entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartItemMapper {
    @Mapping(target = "productName", source = "variant.product.name")
    CartItemDTO toDTO(CartItem entity);

    @Mapping(target = "variant", ignore = true)
    @Mapping(target = "cart", ignore = true)
    CartItem toEntity(CartItemDTO dto);
}
