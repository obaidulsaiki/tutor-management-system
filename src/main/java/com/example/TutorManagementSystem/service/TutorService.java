package com.example.TutorManagementSystem.service;

import com.example.TutorManagementSystem.DTO.TutorDTO;
import com.example.TutorManagementSystem.entity.Course;
import com.example.TutorManagementSystem.entity.Tutor;
import com.example.TutorManagementSystem.repository.CourseRepo;
import com.example.TutorManagementSystem.repository.StudentRepo;
import com.example.TutorManagementSystem.repository.TutorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TutorService {
    private final TutorRepo tutorRepo;
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    public String addTutor(TutorDTO tutorDTO) {
        Tutor tutor = new Tutor();
        List<Tutor> tutorList = tutorRepo.findAll();
        if(tutorList.stream().anyMatch(b -> b.getEmail().equals(tutorDTO.getEmail()))){
            return "Email Already Exists";
        }
        tutor.setName(tutorDTO.getName());
        tutor.setEmail(tutorDTO.getEmail());
        tutor.setPassword(tutorDTO.getPassword());
        tutor.setPhoneNumber(tutorDTO.getPhoneNumber());
        tutor.setExperience(tutorDTO.getExperience());
        tutor.setSpeciality(tutorDTO.getSpeciality());
        tutorRepo.save(tutor);
        return "Tutor Added Successfully";
    }

    public void deleteTutor(String name) {
        List<Tutor> tutorList = tutorRepo.findAll();
        List<Tutor> tutor = tutorList.stream().filter(b -> b.getName().equals(name)).toList();
        tutorRepo.deleteAll(tutor);

    }

    public void updateTutor(String gmail, TutorDTO tutorDTO) {
        List<Tutor> tutorList = tutorRepo.findAll();
        Tutor tutor = tutorList.
                stream().
                filter(b -> b.getEmail().
                        equals(gmail)).
                findFirst().
                orElseThrow(()->new RuntimeException("Tutor Not Found"));
        tutor.setName(tutorDTO.getName());
        tutor.setEmail(tutorDTO.getEmail());
        tutor.setPassword(tutorDTO.getPassword());
        tutor.setPhoneNumber(tutorDTO.getPhoneNumber());
        tutor.setExperience(tutorDTO.getExperience());
        tutor.setSpeciality(tutorDTO.getSpeciality());
        tutorRepo.save(tutor);
    }

    public void assignCourse(String gmail, int courseId) {
        List<Tutor> tutorList = tutorRepo.findAll();
        Tutor tutor = tutorList.
                stream().
                filter(b -> b.getEmail().
                        equals(gmail)).
                findFirst().
                orElseThrow(()->new RuntimeException("Tutor Not Found"));
        List<Integer> courseList = tutor.getCourses().
                stream().
                map(b -> b.getId()).toList();
        if(courseList.contains(courseId)){
            throw new RuntimeException("Course Already Assigned");
        }
        else {
            Course course = courseRepo.findById(courseId).orElseThrow(()->new RuntimeException("Course Not Found"));
            tutor.getCourses().add(course);
        }
        tutorRepo.save(tutor);
    }

    public List<Tutor> getAllTutorInfo() {
        List<Tutor> tutorList = tutorRepo.findAll();
        return tutorList;
    }
}
