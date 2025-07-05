package com.example.TutorManagementSystem.service;

import com.example.TutorManagementSystem.DTO.CourseDTO;
import com.example.TutorManagementSystem.entity.Course;
import com.example.TutorManagementSystem.entity.Student;
import com.example.TutorManagementSystem.repository.CourseRepo;
import com.example.TutorManagementSystem.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {
    public final CourseRepo courseRepo;
    public final StudentRepo studentRepo;
    public void insertCourse(CourseDTO courseDTO){
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setSubjectArea(courseDTO.getSubjectArea());
        courseRepo.save(course);
    }

    public void addCourse(int id, int courseId) {
       Student student = studentRepo.findById(id).orElseThrow(()->new RuntimeException("Student Not Found"));
       Course course = courseRepo.findById(courseId).orElseThrow(()->new RuntimeException("Course Not Found"));
       Set<Student> studentList = new HashSet<>();
       studentList.add(student);
       course.setStudents(studentList);
       courseRepo.save(course);
       student.getCourses().add(course);
       studentRepo.save(student);
    }

    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    public void updateCourse(int id, CourseDTO courseDTO) {
        Course course = courseRepo.findById(id).orElseThrow(()->new RuntimeException("Course Not Found"));
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setSubjectArea(courseDTO.getSubjectArea());
        courseRepo.save(course);

    }

    public void deleteCourse(int id) {
        Course course = courseRepo.findById(id).orElseThrow(()->new RuntimeException("Course Not Found"));
        courseRepo.delete(course);


    }

    public void addBulkCourse(List<CourseDTO> courseDTOList) {
        List<Course> courseList = new ArrayList<>();
        courseDTOList.forEach(courseDTO -> {
            Course course = new Course();
            course.setName(courseDTO.getName());
            course.setDescription(courseDTO.getDescription());
            course.setSubjectArea(courseDTO.getSubjectArea());
            courseList.add(course);
        });
        courseRepo.saveAll(courseList);
    }
}
