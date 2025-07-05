package com.example.TutorManagementSystem.repository;

import com.example.TutorManagementSystem.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment,Integer> {
}
