package com.example.riporting.repository;

import com.example.riporting.repository.entity.Customer;
import com.example.riporting.repository.entity.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailAddressRepository extends JpaRepository<EmailAddress, Long> {
    public EmailAddress findFirstByCustomer(Customer customer);
}
