package com.next_website_be.Mapper;

import com.next_website_be.DTO.NotificationDTO;
import com.next_website_be.Entities.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationDTO toDTO(Notification entity);
    Notification toEntity(NotificationDTO dto);
}