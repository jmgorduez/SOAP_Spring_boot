package com.gestorinc.ws;

import com.gestorinc.ws.repositories.abstractions.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.gestorinc.ws.util.Constants.STUDENTS;

@SpringBootApplication
public class WebserviceApplication implements CommandLineRunner {

	@Autowired
	private IStudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		STUDENTS.values()
				.forEach(studentRepository::save);
	}
}
