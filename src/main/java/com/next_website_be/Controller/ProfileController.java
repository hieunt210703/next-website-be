package com.next_website_be.Controller;

import java.util.List;

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
@RequiredArgsConstructor
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getAllProfiles(){
        return profileService.getAllProfiles();
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @GetMapping("/{id}")
    public Profile getProfileById(@PathVariable Integer id) {
        return profileService.getProfileById(id);

    }

    @PutMapping("/{id}")
    public Profile updateProfile(@PathVariable Integer id, @RequestBody Profile profile) {
        return profileService.updateProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Integer id) {
        profileService.deleteProfile(id);
    }
}
