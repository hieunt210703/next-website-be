package com.next_website_be.Mapper;

import com.next_website_be.DTO.Request.BrandRequestDTO;
import com.next_website_be.DTO.Response.BrandResponseDTO;
import com.next_website_be.Entities.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toEntity(BrandRequestDTO dto);
    BrandResponseDTO toDTO(Brand entity);
}
