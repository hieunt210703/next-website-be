package com.next_website_be.Mapper;

import com.next_website_be.DTO.RoleDTO;
import com.next_website_be.DTO.UserDTO;
import com.next_website_be.Entities.Role;
import com.next_website_be.Entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDTO(Role entity);
    Role toEntity(RoleDTO dto);
}
