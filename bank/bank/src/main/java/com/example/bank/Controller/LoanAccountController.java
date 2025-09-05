package com.example.bank.Controller;

import com.example.bank.DTO.LoanAccountDTO;
import com.example.bank.Service.LoanAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoanAccountController {
    private final LoanAccountService loanAccountService;

    @PostMapping(value = "/loan/insert")
    public void addLoanAccount(@RequestBody LoanAccountDTO loanAccountDTO){
     loanAccountService.addLoanInfo(loanAccountDTO);
    }
}
