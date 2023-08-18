package services;

import Repositories.StudentRepository;
import models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void registerStudent(Student student) {
        if (studentRepository.findStudentByEmail(student.getEmail()).isEmpty()){
            studentRepository.save(student);
        } else {
            throw new IllegalStateException("Email taken");
        }
    }

    public void deleteStudent(long studentid){
        if (studentRepository.existsById(studentid)){
            studentRepository.deleteById(studentid);
        } else {
            throw new IllegalStateException("student doesn't exist");
        }
    }

    public void updateStudentName(Long studentid, String name){
        if(studentRepository.existsById(studentid)){
            Optional<Student> student = studentRepository.findById(studentid);
            student.get().setName(name);
            studentRepository.save(student.get());
        } else{
            throw new IllegalStateException("student doesn't exist");
        }
    }

    public void updateStudent(Long studentId, String name, String email){
        Optional<Student> student = studentRepository.findById(studentId);
        if(studentRepository.existsById(studentId) && !student.get().getName().equals(name)){
            student.get().setName(name);
            student.get().setEmail(email);
            studentRepository.save(student.get());
        } else{
            throw new IllegalStateException("student doesn't exist");
        }

    }
}