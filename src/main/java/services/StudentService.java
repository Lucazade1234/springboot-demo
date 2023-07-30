package services;

import models.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public StudentService() {
    }

    public List<Student> getStudents(){
        return List.of(
                new Student(1L,
                        "Luca",
                        "luca.khatri@gmail.com",
                        LocalDate.of(2002,4,24),
                        21));
    }
}