package com.next_website_be.Mapper;

import com.next_website_be.DTO.UserDTO;
import com.next_website_be.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roleId", source = "role.id")
    @Mapping(target = "roleName", source = "role.name")
    UserDTO toDTO(User entity);

    @Mapping(target = "role.id", source = "roleId")
    User toEntity(UserDTO dto);
}
