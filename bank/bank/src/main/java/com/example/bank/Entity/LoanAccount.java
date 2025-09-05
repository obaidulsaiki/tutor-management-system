package com.example.bank.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LoanAccount {
    @Id
    private int loanId;
    private double credit;
    private double debit;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "C_id")
    @JsonBackReference
    private Customer customer;
}
