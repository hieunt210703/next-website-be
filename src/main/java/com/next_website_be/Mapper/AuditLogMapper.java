package com.next_website_be.Mapper;

import com.next_website_be.DTO.AuditLogDTO;
import com.next_website_be.Entities.AuditLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuditLogMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    AuditLogDTO toDTO(AuditLog entity);

    @Mapping(target = "user", source = "userId")
    @Mapping(target = "user.username", ignore = true)
    AuditLog toEntity(AuditLogDTO dto);
}
