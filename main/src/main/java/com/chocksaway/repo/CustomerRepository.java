package com.chocksaway.repo;

import com.chocksaway.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Author milesd on 22/03/2019.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    Optional<Customer> findById(Long id);

    List<Customer> findByDobBefore(LocalDate date);
}
