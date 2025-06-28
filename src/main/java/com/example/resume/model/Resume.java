package com.example.resume.model;

import java.util.ArrayList;
import java.util.List;

public class Resume {
    private List<Section> sections = new ArrayList<>();

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
