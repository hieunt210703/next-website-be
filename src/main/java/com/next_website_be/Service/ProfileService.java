package com.next_website_be.Service;

import com.next_website_be.ApiResponse.DTO_Response.ProfileDTO;
import com.next_website_be.ApiResponse.Error_Response.ApiException;
import com.next_website_be.Entities.Profile;
import com.next_website_be.Mapper.ProfileMapper;
import com.next_website_be.Repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileMapper profileMapper;

    public ProfileDTO create(ProfileDTO dto) {
        Profile profile = profileMapper.toEntity(dto);
        Profile saved = profileRepository.save(profile);
        return profileMapper.toDto(saved);
    }

    public ProfileDTO getById(Integer id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ApiException.ResourceNotFoundException("Profile not found with id: " + id));
        return profileMapper.toDto(profile);
    }

    public List<ProfileDTO> getAll() {
        return profileMapper.toDtoList(profileRepository.findAll());
    }

    public ProfileDTO update(Integer id, ProfileDTO dto) {
        Profile existing = profileRepository.findById(id)
                .orElseThrow(() -> new ApiException.ResourceNotFoundException("Profile not found with id: " + id));

        existing.setFullName(dto.getFullName());
        existing.setUsername(dto.getUsername());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setGender(dto.getGender());
        existing.setAddress(dto.getAddress());

        Profile updated = profileRepository.save(existing);
        return profileMapper.toDto(updated);
    }

    public void softDelete(Integer id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ApiException.ResourceNotFoundException("Profile not found with id: " + id));

        if (profile.getDeletedAt() != null) {
            throw new ApiException.AlreadyDeletedException("Profile with id " + id + " is already deleted");
        }

        profile.setDeletedAt(LocalDateTime.now());
        profileRepository.save(profile);
    }
}
