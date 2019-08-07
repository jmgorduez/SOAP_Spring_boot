package com.gestorinc.ws.controllers;

import com.gestorinc.ws.controllers.model.*;
import com.gestorinc.ws.services.abstractions.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.gestorinc.ws.util.Constants.*;

@Endpoint
public class StudentEndpoint{

    private IStudentService studentService;
 
    @Autowired
    public StudentEndpoint(IStudentService studentService) {
        this.studentService = studentService;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = GET_STUDENT_DETAILS_REQUEST)
    @ResponsePayload
    public GetStudentDetailsResponse getStudent(@RequestPayload GetStudentDetailsRequest request) {
        GetStudentDetailsResponse response = new GetStudentDetailsResponse();
        response.setStudent(studentService.getStudent(request.getName()));
 
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = GET_ALL_STUDENTS_REQUEST)
    @ResponsePayload
    public GetAllStudentsResponse getAllStudents() {
        GetAllStudentsResponse response = new GetAllStudentsResponse();
        response.getStudents().addAll(studentService.getAllStudents());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = ADD_STUDENT_REQUEST)
    @ResponsePayload
    public AddStudentResponse addStudent(@RequestPayload AddStudentRequest request) {
        AddStudentResponse response = new AddStudentResponse();

        Student student = studentService
                .addStudent(request.getName(),request.getStandard(),request.getAddress());
        response.setStudent(student);

        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode(SUCCESS);
        response.setServiceStatus(serviceStatus);

        return response;
    }
}