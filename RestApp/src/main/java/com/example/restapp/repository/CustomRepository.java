package com.example.restapp.repository;

import com.example.restapp.repository.entity.DoctorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

//    @Query
//    public List<DoctorEntity> getAllDoctorNativeQuery() {
//        String nativeQuery = "SELECT * FROM doctor_entity";
//        List<DoctorEntity> resultList = entityManager.createNativeQuery(nativeQuery, DoctorEntity.class).getResultList();
//        return resultList;
//    }


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
    public void saveTwoDoctors(DoctorEntity doctor1, DoctorEntity doctor2) {
        try {
            save(doctor1);
            save(doctor2);
        } catch(Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Transaction failed ", e);
        }
    }
}
