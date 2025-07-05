package com.example.TutorManagementSystem.service;

import com.example.TutorManagementSystem.DTO.TutorClassDTO;
import com.example.TutorManagementSystem.entity.Course;
import com.example.TutorManagementSystem.entity.Tutor;
import com.example.TutorManagementSystem.entity.TutorClass;
import com.example.TutorManagementSystem.repository.CourseRepo;
import com.example.TutorManagementSystem.repository.TutorClassRepo;
import com.example.TutorManagementSystem.repository.TutorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TutorClassService {
    private final TutorClassRepo tutorClassRepo;
    private final TutorRepo tutorRepo;
    private final CourseRepo courseRepo;

    public List<TutorClass> getAllClassInfo() {
        List<TutorClass> tutorClassList = tutorClassRepo.findAll();
        return tutorClassList;
    }

    public String addClass(TutorClassDTO tutorClassDTO, String courseName, String tutorName) {
        TutorClass tutorClass = new TutorClass();
        tutorClass.setStartEnd(tutorClassDTO.getStartEnd());
        tutorClass.setStartTime(tutorClassDTO.getStartTime());
        tutorClass.setClassType(tutorClassDTO.getClassType());
        tutorClass.setLocation(tutorClassDTO.getLocation());

        List<Tutor> tutorList = tutorRepo.findAll();
        List<Course> courseList = courseRepo.findAll();
        Course course = new Course();


        Tutor tutor = tutorList.stream().filter(b -> {
            if (b.getName().equals(tutorName) && b.getCourses().
                    stream().
                    anyMatch(c ->
                            c.getName().equals(courseName))
            ) {
                Course c = b.getCourses().stream().filter(c1 -> c1.getName().equals(courseName)).findFirst().orElseThrow(()->new RuntimeException("Course Not Found"));
                return true;
            }
            return false;
        }).findFirst().orElseThrow(()->new RuntimeException("Tutor Not Found"));


        tutorClass.setTutor(tutor);
        tutorClass.setCourse(course);
        tutorClassRepo.save(tutorClass);

        tutor.getTutorClass().add(tutorClass);
        tutorRepo.save(tutor);
        return "Class Added Successfully";

    }

    public String updateClassScheduled(int id, TutorClassDTO tutorClassDTO) {
        TutorClass tutorClass = tutorClassRepo.findById(id).orElseThrow(()->new RuntimeException("Class Not Found"));
        tutorClass.setStartTime(tutorClassDTO.getStartTime());
        tutorClass.setClassType(tutorClassDTO.getClassType());
        tutorClass.setLocation(tutorClassDTO.getLocation());
        tutorClassRepo.save(tutorClass);
        return "Class Updated Successfully";
    }

    public String deleteClass(int id) {
        TutorClass tutorClass = tutorClassRepo.findById(id).orElseThrow(()->new RuntimeException("Class Not Found"));
        tutorClassRepo.delete(tutorClass);
        return "Class Deleted Successfully";
    }
}
