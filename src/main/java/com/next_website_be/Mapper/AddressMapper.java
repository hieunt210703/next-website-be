package com.next_website_be.Mapper;

import com.next_website_be.DTO.AddressDTO;
import com.next_website_be.Entities.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTO toDTO(Address entity);
    Address toEntity(AddressDTO dto);
}
