package com.ersin.spring_data_jpa.repository;

import com.ersin.spring_data_jpa.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "from Customer c WHERE c.id = :customerId")
    Optional<Customer> findCustomerById(Long customerId);
    @Query(value = "select * from student.customer", nativeQuery = true)
    List<Customer> getAllCustomers();
}
