package edu.iu.nibomm.primesservice.repository;

import edu.iu.nibomm.primesservice.model.Customer;

import java.io.IOException;

public interface IAuthenticationRepository {
    boolean save(Customer customer) throws IOException;
    Customer findbyUsername(String username) throws IOException;
}
