package com.next_website_be.Mapper;

import com.next_website_be.DTO.CategoryDTO;
import com.next_website_be.Entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category entity);
    Category toEntity(CategoryDTO dto);
}
