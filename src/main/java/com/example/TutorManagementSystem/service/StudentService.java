package com.example.TutorManagementSystem.service;

import com.example.TutorManagementSystem.DTO.PaymentDTO;
import com.example.TutorManagementSystem.DTO.StudentDTO;
import com.example.TutorManagementSystem.entity.Payment;
import com.example.TutorManagementSystem.entity.Student;
import com.example.TutorManagementSystem.repository.PaymentRepo;
import com.example.TutorManagementSystem.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final PaymentRepo paymentRepo;

    public void insertStudent(StudentDTO studentDTO){
        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setPassword(studentDTO.getPassword());
        student.setDate(studentDTO.getDate());
        studentRepo.save(student);

    }
    public List<Student> getAllStudent() {
        return studentRepo.findAll(); // table row
    }

    public void updateStudent(int id, StudentDTO studentDTO) {
        Student student = studentRepo.findById(id).orElseThrow(()->new RuntimeException("Student Not Found"));
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setDate(studentDTO.getDate());
        studentRepo.save(student);
    }

    public void deleteStudent(int id) {

        Student student = studentRepo.findById(id).orElseThrow(()->new RuntimeException("Student Not Found"));
        studentRepo.delete(student);
    }

    public void updatePayment(int id, PaymentDTO paymentDTO) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));

        Payment payment = new Payment();
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setMethod(paymentDTO.getMethod());
        payment.setStatus(paymentDTO.getStatus());
        payment.setStudent(student);
        paymentRepo.save(payment);
        student.getPayment().add(payment);
        studentRepo.save(student);

    }
}
