package com.example.TutorManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String speciality;
    private String email;
    private String phoneNumber;
    private String password;
    private String experience;

    @OneToOne(mappedBy = "tutor")
    @JsonBackReference
    private TutorPayment tutorPayment;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tutor_course",
            joinColumns = @JoinColumn(name = "tutor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonBackReference
    private Set<Course> courses;
    @OneToMany(mappedBy = "tutor",cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Set<TutorClass> tutorClass;
}
