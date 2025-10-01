package com.next_website_be.Controller;

import java.util.List;

import com.next_website_be.ApiResponse.DTO_Response.ProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next_website_be.Entities.Profile;
import com.next_website_be.Service.ProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<ProfileDTO> getAllProfiles(){
        return profileService.getAll();
    }

    @PostMapping
    public ProfileDTO createProfile(@RequestBody ProfileDTO profileDTO) {
        return profileService.create(profileDTO);
    }

    @GetMapping("/{id}")
    public ProfileDTO getProfileById(@PathVariable Integer id) {
        return profileService.getById(id);

    }

    @PutMapping("/{id}")
    public ProfileDTO updateProfile(@PathVariable Integer id, @RequestBody ProfileDTO profileDTO) {
        return profileService.update(id, profileDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Integer id) {
        profileService.softDelete(id);
    }
}
