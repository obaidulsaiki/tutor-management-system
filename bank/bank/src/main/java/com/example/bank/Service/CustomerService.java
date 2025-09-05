package com.example.bank.Service;

import com.example.bank.DTO.CustomerDTO;
import com.example.bank.Entity.Customer;
import com.example.bank.Repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;

    public void addCustomer(CustomerDTO customerDTO){
    Customer customer = new Customer();
    customer.setCustomerId(customerDTO.getCustomerId());
    customer.setName(customerDTO.getName());
    customer.setMoney(customerDTO.getMoney());
    customerRepo.save(customer);
    }

}
