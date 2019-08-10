package com.gestorinc.ws.repositories.abstractions;

import com.gestorinc.ws.repositories.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends CrudRepository<StudentDTO, String> {
    StudentDTO findStudentByName(String name);
    List<StudentDTO> findAll();
}
