package com.orxanibrahim.resume_portal.service;

import com.orxanibrahim.resume_portal.model.UserProfile;
import com.orxanibrahim.resume_portal.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public String chooseTemplateBasedOnUser(String userId, Model model) {
        Optional<UserProfile> userProfile = userProfileRepository.findByUsername(userId);
        userProfile.orElseThrow(() -> new RuntimeException("user not found : " + userId));
        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile);
        return "profile-templates/" + userProfile.get().getId() + "/index";
    }
}
