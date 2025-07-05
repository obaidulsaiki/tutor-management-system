package com.example.TutorManagementSystem.controller;

import com.example.TutorManagementSystem.DTO.CourseDTO;
import com.example.TutorManagementSystem.entity.Course;
import com.example.TutorManagementSystem.service.CourseService;
import com.example.TutorManagementSystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final StudentService studentService;

    @GetMapping(value = "course/welcome")
    public String ShowMessege(){
        return "Welcome to Course Page";
    }
    @GetMapping(value = "course/get_all_courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourse();
    }
    @PostMapping(value = "course/add")
    public void insertCourse(@RequestBody CourseDTO courseDTO)
    {
        courseService.insertCourse(courseDTO);
    }
    @PostMapping(value = "course/add_bulk_course")
    public void insertBulkCourse(@RequestBody List<CourseDTO> courseDTOList){
        courseService.addBulkCourse(courseDTOList);
    }
    // putmapping use value update
    @PutMapping(value = "course/update/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody CourseDTO courseDTO){
        courseService.updateCourse(id,courseDTO);
    }


    @DeleteMapping(value = "course/delete/{id}")
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
    }

}
