package com.next_website_be.Mapper;

import com.next_website_be.DTO.ProductImageDTO;
import com.next_website_be.Entities.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    ProductImageDTO toDTO(ProductImage entity);
    ProductImage toEntity(ProductImageDTO dto);
}
