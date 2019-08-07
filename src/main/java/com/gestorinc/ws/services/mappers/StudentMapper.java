package com.gestorinc.ws.services.mappers;

import com.gestorinc.ws.controllers.model.Student;
import com.gestorinc.ws.repositories.dto.StudentDTO;
import com.gestorinc.ws.services.mappers.abstractions.IStudentMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements IStudentMapper {
    @Override
    public Student mapToStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setStandard(studentDTO.getStandard());
        student.setAddress(studentDTO.getAddress());
        return student;
    }
}
