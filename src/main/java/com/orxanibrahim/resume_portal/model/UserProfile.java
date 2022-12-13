package com.orxanibrahim.resume_portal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int theme;
    private String summary;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String designation;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //if user profile removed remove Jobs also
    @JoinColumn(name = "job_id")
    private List<Jobs> jobs = new ArrayList<>();
}
