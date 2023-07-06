package com.example.restapp.repository;

import com.example.restapp.exception.DoctorValidationException;
import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.service.model.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public DoctorEntity findById(Long id) {
        return entityManager.find(DoctorEntity.class, id);
    }


    @Query
    public List<DoctorEntity> getAllDoctor() {
        return entityManager.createQuery("SELECT s FROM DoctorEntity s", DoctorEntity.class).getResultList();
    }

    @Query
    public DoctorEntity findByName(String name) {
        TypedQuery<DoctorEntity> query = entityManager.createQuery("SELECT d FROM DoctorEntity d WHERE d.name = :name", DoctorEntity.class);
        query.setParameter("name", name);
        List<DoctorEntity> results = query.getResultList();
        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }

    @Transactional
    public DoctorEntity save(DoctorEntity doctorEntity) {
    //    begin();, commit(), rollback();
        if(doctorEntity.getId() != null) {
            entityManager.merge(doctorEntity);
        } else {
            entityManager.persist(doctorEntity);
        }
        return doctorEntity;
    }
    @Transactional
    public void saveTwoDoctors(DoctorEntity doctor1, DoctorEntity doctor2) throws DoctorValidationException {
        try {
            save(doctor1);
            save(doctor2);
        } catch(Exception e) {
            throw new DoctorValidationException("Cannot create Doctors: " + doctor1.getName() + ", " + doctor2.getName() + " " + e.getMessage());
        }
    }
}
