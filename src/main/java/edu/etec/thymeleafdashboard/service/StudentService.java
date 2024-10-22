package edu.etec.thymeleafdashboard.service;

import edu.etec.thymeleafdashboard.model.entities.Student;
import edu.etec.thymeleafdashboard.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
