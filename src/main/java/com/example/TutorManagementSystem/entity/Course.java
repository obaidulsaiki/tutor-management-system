package com.example.TutorManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String subjectArea;

    @ManyToMany(mappedBy = "courses",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Tutor> tutor;

    @ManyToMany(mappedBy = "courses",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Student> students = new HashSet<>();
    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Submission> submission;

    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<TutorClass> tutorClass;
    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<TutorPayment> tutorPayment;
}
