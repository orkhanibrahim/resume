package com.example.resume.model;

import java.util.ArrayList;
import java.util.List;

public class ResumeData {
    private String name;
    private String email;
    private String phone;
    private List<ResumeSection> sections = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ResumeSection> getSections() {
        return sections;
    }

    public void setSections(List<ResumeSection> sections) {
        this.sections = sections;
    }
}
