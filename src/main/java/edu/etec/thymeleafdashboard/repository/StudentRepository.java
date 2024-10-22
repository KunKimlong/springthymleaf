package edu.etec.thymeleafdashboard.repository;

import edu.etec.thymeleafdashboard.model.entities.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentRepository {
    @Select("SELECT * FROM students ORDER BY id DESC")
    List<Student> getAllStudents();
    @Insert("INSERT INTO students (name,gender,cources,profile) VALUES (#{student.name},#{student.gender},#{student.cources},#{student.profile})")
    void addStudent(@Param("student") Student student);

}
