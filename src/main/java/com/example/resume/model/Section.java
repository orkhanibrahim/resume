package com.example.resume.model;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String title;
    private List<String> entries = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getEntries() {
        return entries;
    }

    public void setEntries(List<String> entries) {
        this.entries = entries;
    }
}
