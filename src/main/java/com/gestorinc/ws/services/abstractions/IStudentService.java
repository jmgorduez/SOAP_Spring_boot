package com.gestorinc.ws.services.abstractions;

import com.gestorinc.ws.controllers.model.Student;

import java.util.List;

public interface IStudentService {
    Student getStudent(String name);
    List<Student> getAllStudents();
    Student addStudent(String name,
                    int standard,
                    String address);
}