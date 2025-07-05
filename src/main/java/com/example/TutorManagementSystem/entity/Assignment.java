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
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private LocalDate date;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tutor_class_id")
    @JsonBackReference
    private TutorClass tutorClassAssign;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    @OneToMany(mappedBy = "assignment",cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Submission> submission;
}

