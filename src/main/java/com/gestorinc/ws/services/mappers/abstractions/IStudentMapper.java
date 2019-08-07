package com.gestorinc.ws.services.mappers.abstractions;

import com.gestorinc.ws.controllers.model.Student;
import com.gestorinc.ws.repositories.dto.StudentDTO;

public interface IStudentMapper {
    Student mapToStudent(StudentDTO studentDTO);
}
