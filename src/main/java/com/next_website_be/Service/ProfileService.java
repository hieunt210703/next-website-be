package com.next_website_be.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next_website_be.Entities.Profile;
import com.next_website_be.Repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {
    @Autowired
    private  ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfileById(Integer id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Integer id, Profile profile) {
        Profile existing = getProfileById(id);
        existing.setFullName(profile.getFullName());
        existing.setEmail(profile.getEmail());
        existing.setPhone(profile.getPhone());
        return profileRepository.save(existing);
    }

    public void deleteProfile(Integer id) {
        profileRepository.deleteById(id);
    }
}
