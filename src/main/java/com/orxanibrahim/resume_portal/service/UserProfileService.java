package com.orxanibrahim.resume_portal.service;

import com.orxanibrahim.resume_portal.model.Job;
import com.orxanibrahim.resume_portal.model.UserProfile;
import com.orxanibrahim.resume_portal.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
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
        System.out.println(userProfile.getJobs());
        return "profile-templates/" + userProfile.getId() + "/index";
    }

    public void createJobInstances() {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUsername("orxan");
        userProfileOptional.orElseThrow(() -> new RuntimeException("user not found : "));

        var userProfile1 = userProfileOptional.get();
        Job job1 = Job.builder()
                .company("company 1")
                .designation("Designation 1")
                .id(1)
                .startDate(LocalDate.of(2018,10,20))
                .endDate(LocalDate.of(2020,8,22))
                .build();
        Job job2 = Job.builder()
                .company("company 2")
                .designation("Designation 2")
                .id(2)
                .startDate(LocalDate.of(2020,8,23))
                .endDate(LocalDate.of(2022,12,15))
                .build();

        userProfile1.getJobs().clear(); //todo: added temporarily, because other piece of code has a reference to the same list when page reloaded
        userProfile1.getJobs().add(job1);
        userProfile1.getJobs().add(job2);


        userProfileRepository.save(userProfile1);
    }
}
