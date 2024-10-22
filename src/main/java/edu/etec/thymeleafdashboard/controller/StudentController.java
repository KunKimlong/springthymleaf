package edu.etec.thymeleafdashboard.controller;

import edu.etec.thymeleafdashboard.model.dto.StudentDto;
import edu.etec.thymeleafdashboard.model.entities.Student;
import edu.etec.thymeleafdashboard.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/dashboard")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/viewStudent")
    public String index(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "viewStudent";
    }
    @GetMapping("/addStudent")
    public String addStudent(Model model) {//open form
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);
        return "addStudent";
    }
    @PostMapping("/addStudent")
    public String addStudent(StudentDto studentDto) {
        String dir = "public/profile/";
        try{
            Random rand = new Random();
            String fileName = rand.nextInt(1,99999)+studentDto.getProfile().getOriginalFilename();
            //upload to profile
            Files.copy(studentDto.getProfile().getInputStream(),Paths.get(dir + fileName));

            //send service
            Student student = new Student();
            student.setName(studentDto.getName());
            student.setGender(studentDto.getGender());
            student.setCources(studentDto.getCources());
            student.setProfile(fileName);
            studentService.addStudent(student);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "addStudent";
    }

    @GetMapping("/updateStudent")
    public String updateStudent() {
        return "updateStudent";
    }
}
