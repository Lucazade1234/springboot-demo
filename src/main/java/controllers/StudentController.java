package controllers;


import models.Student;
import com.example.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import services.StudentService;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student){
        studentService.registerStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "updateName/{studentId}/{name}")
    public void updateStudentName(@PathVariable("studentId") Long studentId,
                                  @PathVariable("name") String name){
        studentService.updateStudentName(studentId, name);
    }

    @Transactional
    @PutMapping(path = "updatestudent/{studentId}/{name}/{email}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @PathVariable("name") String name,
                              @PathVariable("email") String email){
        studentService.updateStudent(studentId, name, email);
    }
}
