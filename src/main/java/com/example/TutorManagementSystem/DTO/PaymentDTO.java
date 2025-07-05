package com.example.TutorManagementSystem.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PaymentDTO {
    private int id;

    private int amount;  // better than String for money
    private LocalDate paymentDate;
    private String method;
    private String status;
}
