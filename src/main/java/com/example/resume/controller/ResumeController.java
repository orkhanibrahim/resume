package com.example.resume.controller;

import com.example.resume.model.ResumeData;
import com.example.resume.model.ResumeSection;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ResumeController {

    @GetMapping("/resume")
    public String showForm(HttpSession session, Model model) {
        ResumeData data = (ResumeData) session.getAttribute("resume");
        if (data == null) {
            data = new ResumeData();
        }
        model.addAttribute("resumeData", data);
        return "resumeForm";
    }

    @PostMapping("/resume")
    public String submitForm(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam(required = false) String phone,
                             @RequestParam(name = "sectionTitles", required = false) List<String> sectionTitles,
                             @RequestParam(name = "sectionContents", required = false) List<String> sectionContents,
                             HttpSession session) {
        ResumeData data = new ResumeData();
        data.setName(name);
        data.setEmail(email);
        data.setPhone(phone);

        List<ResumeSection> sections = new ArrayList<>();
        if (sectionTitles != null && sectionContents != null) {
            for (int i = 0; i < Math.min(sectionTitles.size(), sectionContents.size()); i++) {
                String t = sectionTitles.get(i);
                String c = sectionContents.get(i);
                if ((t != null && !t.isBlank()) || (c != null && !c.isBlank())) {
                    sections.add(new ResumeSection(t, c));
                }
            }
        }
        data.setSections(sections);
        session.setAttribute("resume", data);
        return "redirect:/resume/view";
    }

    @GetMapping("/resume/view")
    public String viewResume(HttpSession session, Model model) {
        ResumeData data = (ResumeData) session.getAttribute("resume");
        if (data == null) {
            return "redirect:/resume";
        }
        model.addAttribute("resume", data);
        return "resumeView";
    }
}
