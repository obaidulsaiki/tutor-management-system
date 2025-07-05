package com.example.TutorManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class TutorClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate startTime;
    private LocalDate startEnd;
    private String classType;
    private String location;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;
    @ManyToMany(mappedBy = "tutorClasses",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tutor_id")
    @JsonBackReference
    private Tutor tutor;

    @OneToMany(mappedBy = "tutorClass",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Submission> submission;

    @OneToMany(mappedBy = "tutorClassAssign",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Assignment> assignment;



}
