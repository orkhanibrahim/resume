package com.orxanibrahim.resume_portal.repository;

import com.orxanibrahim.resume_portal.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
    Optional<UserProfile> findByUsername(String userName);
}
