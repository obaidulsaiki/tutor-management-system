package com.example.bank.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Customer {
    @Id
    private int customerId;
    private String name;
    private double money;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<LoanAccount> loanAccounts;
}
