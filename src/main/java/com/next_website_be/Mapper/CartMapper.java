package com.next_website_be.Mapper;

import com.next_website_be.DTO.CartDTO;
import com.next_website_be.Entities.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "userId", source = "user.id")
    CartDTO toDTO(Cart entity);

    @Mapping(target = "user", ignore = true)
    Cart toEntity(CartDTO dto);
}
