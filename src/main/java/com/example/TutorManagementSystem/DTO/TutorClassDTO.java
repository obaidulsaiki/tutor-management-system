package com.example.TutorManagementSystem.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class TutorClassDTO {
private int id;
private LocalDate startTime;
private LocalDate startEnd;
private String classType;
private String location;
}
