package com.example.riporting.repository;

import com.example.riporting.repository.entity.Customer;
import com.example.riporting.repository.entity.EmailAddress;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/*
SELECT c.*, e.address AS email
FROM customer c
LEFT JOIN email_address e ON c.id = e.customer_id;
*/
@Repository
public class CustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> findAllCustomersJpql() {
        List<Customer> customers = entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();

        for (Customer customer : customers) {
            List<EmailAddress> emailAddresses = entityManager.createQuery("SELECT e FROM EmailAddress e WHERE e.customer = :customer", EmailAddress.class)
                    .setParameter("customer", customer)
                    .getResultList();
        }

        return customers;
    }



    public List<Customer> findAllCustomersNativeSql() {
        return entityManager.createNativeQuery(
                "SELECT c.*, e.address AS email FROM customer c LEFT JOIN email_address e ON c.id = e.customer_id;", Customer.class
        ).getResultList();
    }
}
