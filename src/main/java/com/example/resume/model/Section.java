package com.example.resume.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic resume section that holds multiple entries.
 */
public class Section {
    private String title;
    private int order;
    private List<Entry> entries = new ArrayList<>();

    public Section() {
    }

    public Section(String title, int order) {
        this.title = title;
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
