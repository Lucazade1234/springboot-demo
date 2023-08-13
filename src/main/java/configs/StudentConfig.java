package configs;

import Repositories.StudentRepository;
import models.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student luca = new Student(
                    "Luca",
                    "luca200284@gmail.com",
                    LocalDate.of(2002, Month.APRIL, 24)
            );

            Student luca2 = new Student(
                    "Luca2",
                    "luca2@gmail.com",
                    LocalDate.of(2005, Month.APRIL, 24)
            );

            studentRepository.saveAll(List.of(luca, luca2));
        };
    }
}
