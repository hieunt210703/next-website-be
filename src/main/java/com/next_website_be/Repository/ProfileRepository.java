package com.next_website_be.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.next_website_be.Entities.Profile;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}