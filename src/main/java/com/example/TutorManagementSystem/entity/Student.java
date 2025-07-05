package com.example.TutorManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Payment> payment;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Submission> submission;

    @ManyToMany(cascade = CascadeType.PERSIST) // students own the relationship, that's why it is initiating
    @JoinTable(
            name = "enrollment",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonBackReference
    private Set<Course> courses;

    @OneToOne(mappedBy = "student",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Assignment assignment;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "student_tutor_class",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<TutorClass> tutorClasses;
}