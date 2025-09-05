package com.example.bank.Repository;

import com.example.bank.Entity.LoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanAccountRepo extends JpaRepository<LoanAccount,Integer> {
}
