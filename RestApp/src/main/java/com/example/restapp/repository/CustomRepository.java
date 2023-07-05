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
        // TODO: NamedQuery entityManager-nek. De legalább kiemelni private final static változóba. Vagy külön final classt tartalmaz ami csak konstansokat, query-ket tárol.
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
            //TODO: null ne adj vissza... Optional<Empty> Optional.of(...) ?
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
            // TODO: Custom exceptiont írni... UnableToSaveDoctor
            throw new RuntimeException("Transaction failed ", e);
        }
    }
}
