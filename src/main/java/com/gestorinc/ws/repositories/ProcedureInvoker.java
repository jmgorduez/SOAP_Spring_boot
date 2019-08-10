package com.gestorinc.ws.repositories;

import com.gestorinc.ws.repositories.abstractions.IProcedureInvoker;
import com.gestorinc.ws.repositories.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import static com.gestorinc.ws.util.Constants.*;

@Repository
public class ProcedureInvoker implements IProcedureInvoker {

    private final EntityManager entityManager;

    @Autowired
    public ProcedureInvoker(final EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public String getStudentNameAt(Integer index) {

        return (String) entityManager.createStoredProcedureQuery(GET_STUDENT_NAME_AT)
                .registerStoredProcedureParameter(INDEX, Integer.class, ParameterMode.IN)
                .setParameter(INDEX, index)
                .getSingleResult();
    }
}