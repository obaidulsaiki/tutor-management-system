package com.example.TutorManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Getter
@Setter
public class TutorPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private LocalDate date;
    private String method;
    private String status;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tutor_id")
    @JsonBackReference
    private Tutor tutor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;

}
