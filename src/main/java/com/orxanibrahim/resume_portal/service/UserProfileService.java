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
        var userProfileOptional = userProfileRepository.findByUsername(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("user not found : " + userId));
        model.addAttribute("userId", userId);
        var userProfile = userProfileOptional.get();
        model.addAttribute("userProfile", userProfile);
        return "profile-templates/" + userProfile.getId() + "/index";
    }
}
