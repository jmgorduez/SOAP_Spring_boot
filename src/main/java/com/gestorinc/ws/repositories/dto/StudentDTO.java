package com.gestorinc.ws.repositories.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

import static com.gestorinc.ws.util.Constants.STUDENT_TABLE_NAME;

@Entity()
@Table(name = STUDENT_TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements Serializable {
    @Id
    @Getter
    @Setter
    @Column
    private String name;
    @Getter
    @Setter
    @Column
    private Integer standard;
    @Getter
    @Setter
    @Column
    private String address;
}
