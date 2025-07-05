package com.example.TutorManagementSystem.controller;

import com.example.TutorManagementSystem.DTO.TutorClassDTO;
import com.example.TutorManagementSystem.entity.TutorClass;
import com.example.TutorManagementSystem.service.StudentService;
import com.example.TutorManagementSystem.service.TutorClassService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TutorClassController {

    private final TutorClassService tutorClassService;
    private final StudentService studentService;

    @GetMapping(value = "class/all_class_information")
    public List<TutorClass> getAllClassInformation(){
        return tutorClassService.getAllClassInfo();
    }
    @PostMapping(value = "class/add/{courseName},{tutorName}")
    public String addClass(@RequestBody TutorClassDTO tutorClassDTO , @PathVariable String courseName, @PathVariable String tutorName){
        return  tutorClassService.addClass(tutorClassDTO,courseName,tutorName);
    }
    @PutMapping(value = "class/update/{id}")
    public String updateClass(@PathVariable int id, @RequestBody TutorClassDTO tutorClassDTO){
        return tutorClassService.updateClassScheduled(id,tutorClassDTO);
    }
    @DeleteMapping(value = "class/delete/{id}")
    public String deleteClass(@PathVariable int id){
        return tutorClassService.deleteClass(id);
    }

}
