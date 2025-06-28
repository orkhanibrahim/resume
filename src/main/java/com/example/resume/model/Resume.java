package com.example.resume.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Resume root entity that contains personal details and sections.
 */
public class Resume {
    private String fullName;
    private String email;
    private String phoneNumber;
    private List<Section> sections = new ArrayList<>();

    public Resume() {
    }

    public Resume(String fullName, String email, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
