package com.gestorinc.ws.services;

import com.gestorinc.ws.controllers.model.Student;
import com.gestorinc.ws.repositories.abstractions.IStudentRepository;
import com.gestorinc.ws.repositories.dto.StudentDTO;
import com.gestorinc.ws.services.abstractions.IStudentService;
import com.gestorinc.ws.services.mappers.abstractions.IStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;
    private final IStudentMapper studentMapper;

    @Autowired
    public StudentService(IStudentRepository studentRepository, IStudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public Student getStudent(String name) {
        return studentMapper.mapToStudent(
                studentRepository.findStudentByName(name));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::mapToStudent).collect(Collectors.toList());
    }

    @Override
    public Student addStudent(String name, int standard, String address) {
        return studentMapper
                .mapToStudent(studentRepository.save(new StudentDTO(name, standard, address)));
    }
}