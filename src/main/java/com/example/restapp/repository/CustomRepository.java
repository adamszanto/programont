package com.example.restapp.repository;

import com.example.restapp.exception.DoctorValidationException;
import com.example.restapp.repository.entity.DoctorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.restapp.repository.QueryList.*;

@Repository
public class CustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public DoctorEntity findById(Long id) {
        return entityManager.find(DoctorEntity.class, id);
    }

    public DoctorEntity nativeFindById(Long id) {
        String nativeQuery = QUERY_FIND_BY_ID;
        jakarta.persistence.Query query = entityManager.createNativeQuery(nativeQuery, DoctorEntity.class);
        query.setParameter("id", id);
        return (DoctorEntity) query.getSingleResult();
    }

    // Criteria API
    public List<DoctorEntity> findByIdGreaterThan(Integer num) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DoctorEntity> criteriaQuery = criteriaBuilder.createQuery(DoctorEntity.class);
        Root<DoctorEntity> root = criteriaQuery.from(DoctorEntity.class);

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.greaterThan(root.get("id"), num));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    public void nativeDeleteAll() {
        String nativeQueryPatients = QUERY_DELETE_PATIENTS;
        String nativeQueryDoctors = QUERY_DELETE_DOCTORS;
        entityManager.createNativeQuery(nativeQueryPatients).executeUpdate();
        entityManager.createNativeQuery(nativeQueryDoctors).executeUpdate();
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
        // Megkapjuk a tranzakciós objektumot. Mérföldkövek: Megmondhatjuk hol kezdődik, hol végződik, plusz félúton is elmenthetjük
        // begin(), commit(), rollback()
        // entityManager.getTransaction().begin();

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

    public Long count() {
        List<Long> result = entityManager.createQuery("SELECT COUNT(s) as cnt FROM DoctorEntity s").getResultList();
        if(!result.isEmpty()) {
            return  result.get(0);
        }
        return 0L;
    }


    @Transactional
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM PatientEntity ").executeUpdate();
        entityManager.createQuery("DELETE FROM DoctorEntity ").executeUpdate();
    }
}
