package com.example.studentManager;

import com.example.studentManager.entity.Student;
import com.example.studentManager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagerApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		/*Student student1 = new Student("Csongi", "Kiss", "csocseszkusz@gmail.com");
		studentRepository.save(student1);

		Student student2 = new Student("Jay", "Cutler", "jaycut@gmail.com");
		studentRepository.save(student2);

		Student student3 = new Student("Ronnie", "Coleman", "ronnicol@gmail.com");
		studentRepository.save(student3);*/
	}
}
