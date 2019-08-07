package com.gestorinc.ws.repositories.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

import static com.gestorinc.ws.util.Constants.STUDENT_TABLE_NAME;

@Entity(name = STUDENT_TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @Id @Getter @Setter
    private String name;
    @Getter @Setter
    private int standard;
    @Getter @Setter
    private String address;
}
