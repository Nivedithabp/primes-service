package edu.iu.nibomm.primesservice.repository;

import edu.iu.nibomm.primesservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AuthenticationDBRepository
        extends CrudRepository<Customer, String> {

    Customer findByUsername(String username);
}