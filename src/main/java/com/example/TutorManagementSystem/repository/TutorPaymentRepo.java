package com.example.TutorManagementSystem.repository;

import com.example.TutorManagementSystem.entity.TutorPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorPaymentRepo extends JpaRepository<TutorPayment,Integer> {
}
