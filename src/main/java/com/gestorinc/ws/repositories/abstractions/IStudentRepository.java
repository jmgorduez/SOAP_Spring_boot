package com.gestorinc.ws.repositories.abstractions;

import com.gestorinc.ws.repositories.dto.StudentDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStudentRepository extends CrudRepository<StudentDTO, String> {
    StudentDTO findStudentByName(String name);
    List<StudentDTO> findAll();
}
