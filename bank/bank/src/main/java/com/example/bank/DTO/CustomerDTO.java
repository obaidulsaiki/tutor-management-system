package com.example.bank.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;



@Data
public class CustomerDTO {
    private int customerId;
    private String name;
    private double money;
}
