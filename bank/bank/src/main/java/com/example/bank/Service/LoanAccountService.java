package com.example.bank.Service;

import com.example.bank.DTO.CustomerDTO;
import com.example.bank.DTO.LoanAccountDTO;
import com.example.bank.Entity.Customer;
import com.example.bank.Entity.LoanAccount;
import com.example.bank.Repository.CustomerRepo;
import com.example.bank.Repository.LoanAccountRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoanAccountService {
    private final LoanAccountRepo loanAccountRepo;
    private final CustomerRepo customerRepo;

    public void addLoanInfo(LoanAccountDTO loanAccountDTO) {
    LoanAccount loanAccount = new LoanAccount();
    loanAccount.setLoanId(loanAccountDTO.getLoanId());
    loanAccount.setCredit(loanAccountDTO.getCredit());
    loanAccount.setDebit(loanAccountDTO.getDebit());

    Customer customer = customerRepo.findById(loanAccountDTO.getCustomerId()).get() ;
    loanAccount.setCustomer(customer);
    loanAccountRepo.save(loanAccount);
    }
}
