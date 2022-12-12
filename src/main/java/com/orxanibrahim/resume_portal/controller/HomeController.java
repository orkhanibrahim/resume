package com.orxanibrahim.resume_portal.controller;

import com.orxanibrahim.resume_portal.model.UserProfile;
import com.orxanibrahim.resume_portal.repository.UserProfileRepository;
import com.orxanibrahim.resume_portal.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileService userProfileService;

    @GetMapping("/")
    public String home() {
        return "Hello buddy";
    }

    @GetMapping("/edit")
    public String edit() {
        return "edit page";
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
       return userProfileService.chooseTemplateBasedOnUser(userId, model);
    }
}
