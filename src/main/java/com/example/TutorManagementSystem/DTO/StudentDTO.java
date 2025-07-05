package com.example.TutorManagementSystem.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class StudentDTO {
    private int id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDate date;

}
