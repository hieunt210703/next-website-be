package com.next_website_be.Mapper;

import com.next_website_be.DTO.BrandDTO;
import com.next_website_be.Entities.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandDTO toDTO(Brand entity);
    Brand toEntity(BrandDTO dto);
}
