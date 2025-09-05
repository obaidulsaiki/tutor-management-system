package com.example.bank.Controller;

import com.example.bank.DTO.CustomerDTO;
import com.example.bank.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(value = "/customer/insert")
    public void addCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(customerDTO);
    }

}
