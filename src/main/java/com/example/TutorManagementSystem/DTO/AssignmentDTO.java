package com.example.TutorManagementSystem.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AssignmentDTO {
    private int id;

    private String title;
    private String description;
    private LocalDate date;
}
