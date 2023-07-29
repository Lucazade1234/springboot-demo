package controllers;


import models.Student;
import com.example.demo.DemoApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    @GetMapping()
    public List<Student> getStudents(){
        return List.of(
                new Student(1L,
                        "Luca",
                        "luca.khatri@gmail.com",
                        LocalDate.of(2002,4,24),
                        21));
    }
}
