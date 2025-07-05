package com.example.TutorManagementSystem.repository;

import com.example.TutorManagementSystem.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission,Integer> {
}
