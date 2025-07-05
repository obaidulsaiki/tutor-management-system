package com.example.TutorManagementSystem.repository;

import com.example.TutorManagementSystem.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepo extends JpaRepository<Tutor,Integer> {
}
