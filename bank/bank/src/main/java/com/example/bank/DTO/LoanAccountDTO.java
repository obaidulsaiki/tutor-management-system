package com.example.bank.DTO;

import lombok.Data;

@Data
public class LoanAccountDTO {
    private int loanId;
    private double credit;
    private double debit;
    private int customerId;
}
