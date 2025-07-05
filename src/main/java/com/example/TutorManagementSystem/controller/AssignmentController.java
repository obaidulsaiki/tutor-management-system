package com.example.TutorManagementSystem.controller;

import com.example.TutorManagementSystem.DTO.AssignmentDTO;
import com.example.TutorManagementSystem.entity.Assignment;
import com.example.TutorManagementSystem.service.AssignmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AssignmentController {
    private final AssignmentService assignmentService;

    @GetMapping(value = "assignment/information/all_assignment_information")
    public List<Assignment> getAllAssignmentInformation(){
        return assignmentService.getAllAssignmentDetailes();
    }
    @PostMapping(value = "assignment/information/add-{className}")
    public String addAssignment(@RequestBody AssignmentDTO assignmentDTO, @PathVariable String className){
        return assignmentService.addAssignment(assignmentDTO);
    }
    @PutMapping(value = "assignment/information/edit-{id}")
    public String updateAssignment(@PathVariable int id, @RequestBody AssignmentDTO assignmentDTO){
        return assignmentService.updateAssignment(id,assignmentDTO);
    }
    @DeleteMapping(value = "assignment/information/delete-{id}")
    public String deleteAssignment(@PathVariable String id){
        return assignmentService.deleteAssignment(id);
    }
}
