package com.next_website_be.Mapper;

import com.next_website_be.ApiResponse.DTO_Response.ProfileDTO;
import com.next_website_be.Entities.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ProfileMapper {
    // Entity -> DTO
    ProfileDTO toDto(Profile profile);

    // DTO -> Entity
    Profile toEntity(ProfileDTO dto);

    // List<Entity> -> List<DTO>
    List<ProfileDTO> toDtoList(List<Profile> profiles);

    // List<DTO> -> List<Entity>
    List<Profile> toEntityList(List<ProfileDTO> dtos);
}

