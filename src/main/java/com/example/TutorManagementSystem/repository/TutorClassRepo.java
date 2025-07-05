package com.example.TutorManagementSystem.repository;

import com.example.TutorManagementSystem.entity.TutorClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorClassRepo extends JpaRepository<TutorClass,Integer> {
}
