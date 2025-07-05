package com.example.TutorManagementSystem.service;

import com.example.TutorManagementSystem.DTO.AssignmentDTO;
import com.example.TutorManagementSystem.entity.Assignment;
import com.example.TutorManagementSystem.entity.Student;
import com.example.TutorManagementSystem.repository.AssignmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssignmentService {
    private final AssignmentRepo assignmentRepo;

    public String addAssignment(AssignmentDTO assignmentDTO) {
        List<Assignment> assignmentList = assignmentRepo.findAll();
        if(assignmentList.stream().anyMatch(b -> b.getTitle().equals(assignmentDTO.getTitle()))){
            return "Assignment Already Exists";
        }
        Assignment assignment = new Assignment();
        assignment.setTitle(assignmentDTO.getTitle());
        assignment.setDescription(assignmentDTO.getDescription());
        assignment.setDate(assignmentDTO.getDate());
        assignmentList.add(assignment);
        assignmentRepo.saveAll(assignmentList);
        return "Assignment Added Successfully";
    }

    public String deleteAssignment(String id) {
        Assignment assignment = assignmentRepo.findById(Integer.parseInt(id)).orElseThrow(()->new RuntimeException("Assignment Not Found"));
        assignmentRepo.delete(assignment);
        return "Assignment Deleted Successfully";
    }

    public List<Assignment> getAllAssignmentDetailes() {
        List<Assignment> assignmentList = assignmentRepo.findAll();
        return assignmentList;
    }

    public String updateAssignment(int id, AssignmentDTO assignmentDTO) {
            Assignment assignment = assignmentRepo.findById(id).orElseThrow(()->new RuntimeException("Assignment Not Found"));
            assignment.setTitle(assignmentDTO.getTitle());
            assignment.setDescription(assignmentDTO.getDescription());
            assignment.setDate(assignmentDTO.getDate());
            assignmentRepo.save(assignment);
            return "Assignment Updated Successfully";
    }
}
