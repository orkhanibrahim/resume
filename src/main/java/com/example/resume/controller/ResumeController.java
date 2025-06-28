package com.example.resume.controller;

import com.example.resume.model.Resume;
import com.example.resume.model.Section;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ResumeController {

    @GetMapping("/resume")
    public String showForm(Model model) {
        Resume resume = new Resume();
        // start with one empty section and one entry for convenience
        Section section = new Section();
        section.getEntries().add("");
        resume.getSections().add(section);
        model.addAttribute("resume", resume);
        return "resumeForm";
    }

    @PostMapping("/resume")
    public String processForm(@ModelAttribute Resume resume, Model model) {
        // remove empty entries
        resume.getSections().forEach(s -> s.getEntries().removeIf(String::isBlank));
        resume.getSections().removeIf(s -> s.getEntries().isEmpty() && (s.getTitle() == null || s.getTitle().isBlank()));
        model.addAttribute("processedResume", resume);
        return "resumeSuccess";
    }
}
