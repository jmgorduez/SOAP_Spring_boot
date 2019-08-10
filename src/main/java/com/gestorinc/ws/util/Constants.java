package com.gestorinc.ws.util;

import com.gestorinc.ws.repositories.dto.StudentDTO;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final Map<String, StudentDTO> STUDENTS = generateStudents();

    public static final String NAMESPACE_URI = "https://www.gestorinc.com/ws";
    public static final String LOCATION_URI = "/service/*";
    public static final String DETAILS_PORT = "DetailsPort";
    public static final String DETAILS_LOCATION_URI = "/service/details";
    public static final String GET_STUDENT_DETAILS_REQUEST = "getStudentDetailsRequest";
    public static final String GET_ALL_STUDENTS_REQUEST = "getAllStudentsRequest";
    public static final String ADD_STUDENT_REQUEST = "addStudentRequest";
    public static final String STUDENT_TABLE_NAME = "student";
    public static final String SUCCESS = "SUCCESS";
    public static final String STUDENT_XSD = "xsds/student.xsd";
    public static final String GET_STUDENT_NAME_AT = "GET_STUDENT_NAME_AT";
    public static final String GET_STUDENT_AT = "GET_STUDENT_AT";
    public static final String INDEX = "index";

    private static Map<String, StudentDTO> generateStudents(){
        Map<String, StudentDTO> students = new HashMap<>();

        StudentDTO student = new StudentDTO("Sajal",5,"Pune");
        students.put(student.getName(), student);

        student = new StudentDTO("Kajal",5,"Chicago");
        students.put(student.getName(), student);

        student = new StudentDTO("Lokesh",6, "Delhi");
        students.put(student.getName(), student);

        student = new StudentDTO("Sukesh", 7, "Noida");
        students.put(student.getName(), student);

        return students;
    }
}
