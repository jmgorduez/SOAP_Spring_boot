package com.gestorinc.ws;

import com.gestorinc.ws.repositories.abstractions.IProcedureInvoker;
import com.gestorinc.ws.repositories.abstractions.IStudentRepository;
import com.gestorinc.ws.repositories.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.stream.Collectors;

import static com.gestorinc.ws.util.Constants.STUDENTS;

@SpringBootApplication
public class WebserviceApplication implements CommandLineRunner {

    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private IProcedureInvoker procedureInvoker;

    public static void main(String[] args) {
        SpringApplication.run(WebserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        insertStudents();
        createStoreProceduresH2();

        System.out.println(procedureInvoker.getStudentNameAt(3));
    }

    private void insertStudents() {
        STUDENTS.values()
                .forEach(studentRepository::save);
    }

    private void createStoreProceduresH2() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "password");
        connection.createStatement()
                .execute("CREATE ALIAS GET_STUDENT_NAME_AT FOR \"com.gestorinc.ws.WebserviceApplication.getStudentNameAt\";");
        connection.commit();
        connection.close();
    }

    public static String getStudentNameAt(Integer index) {
        return STUDENTS.values().stream()
                .collect(Collectors.toList())
                .get(index).getName();
    }
}
