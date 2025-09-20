package com.next_website_be.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.next_website_be.Entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findByUsername(String username);
}