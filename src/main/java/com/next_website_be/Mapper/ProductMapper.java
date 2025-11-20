package com.next_website_be.Mapper;

import com.next_website_be.DTO.ProductDTO;
import com.next_website_be.DTO.Request.ProductRequestDTO;
import com.next_website_be.DTO.Response.ProductResponseDTO;
import com.next_website_be.Entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "brandName", source = "brand.name")
    @Mapping(target = "categoryName", source = "category.name")
    ProductResponseDTO toResponseDTO(Product entity);

    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "category", ignore = true)
    Product toEntity(ProductRequestDTO dto);

    List<ProductResponseDTO> toResponseDTOList(List<Product> entities);
}
