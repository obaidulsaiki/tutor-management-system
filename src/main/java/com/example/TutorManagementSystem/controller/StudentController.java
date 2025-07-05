package com.example.TutorManagementSystem.controller;


import com.example.TutorManagementSystem.DTO.CourseDTO;
import com.example.TutorManagementSystem.DTO.PaymentDTO;
import com.example.TutorManagementSystem.DTO.StudentDTO;
import com.example.TutorManagementSystem.entity.Student;
import com.example.TutorManagementSystem.service.CourseService;
import com.example.TutorManagementSystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    @GetMapping(value = "student/WelcomePage")
    public String MessageDisplay(){
        return "Welcome to Student Page";
    }
    @GetMapping(value = "student/get_all_students")
    public List<Student> getAllStudents(){
    return studentService.getAllStudent();
    }
    @PostMapping(value = "student/insert_data")
    public void insertData( @RequestBody StudentDTO studentDTO){
        studentService.insertStudent(studentDTO);
    }
    @PutMapping(value = "student/update_data/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO){
        studentService.updateStudent(id,studentDTO);
        System.out.println("Student Updated Successfully");
    }

    @DeleteMapping(value = "student/delete_data/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @PostMapping(value = "student/add_payment/{id}")
    public void insertPayment(@PathVariable int id, @RequestBody PaymentDTO paymentDTO){
        studentService.updatePayment(id,paymentDTO);
    }
    @PostMapping(value = "student/enroll_course/{studentId},{courseId}")
    public void enrollCourse(@PathVariable int studentId,@PathVariable int courseId){
        courseService.addCourse(studentId,courseId);
    }
    @PostMapping(value = "student/add_assignment")
    public void insertAssignment(){

    }

}
