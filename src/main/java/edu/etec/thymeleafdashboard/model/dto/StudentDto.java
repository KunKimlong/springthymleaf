package edu.etec.thymeleafdashboard.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    private int id;
    private String name;
    private String gender;
    private String cources;
    private MultipartFile profile;
}
