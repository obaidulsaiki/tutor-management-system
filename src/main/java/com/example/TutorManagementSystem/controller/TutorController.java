package com.example.TutorManagementSystem.controller;

import com.example.TutorManagementSystem.DTO.TutorDTO;
import com.example.TutorManagementSystem.entity.Tutor;
import com.example.TutorManagementSystem.service.StudentService;
import com.example.TutorManagementSystem.service.TutorService;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TutorController {
    private final TutorService tutorService;
    private final StudentService studentService;

    @GetMapping(value = "tutor/welcomepage")
    public String messege(){
        return "Welcome to Tutor Page";
    }
    @GetMapping(value = "tutor/get_all_tutor")
    public List<Tutor> getAllTutor(){
        return tutorService.getAllTutorInfo();
    }

    @PostMapping(value = "tutor/add")
    public String inserTutorData(@RequestBody TutorDTO tutorDTO){
        return tutorService.addTutor(tutorDTO);
    }
    @PostMapping(value ="tutor/course/assign/{gmail},{courseId}")
    public void assignCourse(@PathVariable String gmail, @PathVariable int courseId){
        tutorService.assignCourse(gmail,courseId);

    }
    @PutMapping(value = "tutor/update/gmail/{gmail}")
    public void updateTutorInfo(@PathVariable String gmail, @RequestBody TutorDTO tutorDTO){
        tutorService.updateTutor(gmail,tutorDTO);
    }
    @DeleteMapping(value = "tutor/delete/name/{name}")
    public void deleteTutorInfo(@PathVariable String name){
        tutorService.deleteTutor(name);
    }
}
