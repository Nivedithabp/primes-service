package edu.iu.nibomm.primesservice.service;

import edu.iu.nibomm.primesservice.model.Customer;

import java.io.IOException;

public interface IAuthenticationService {

    boolean register(Customer customer) throws IOException ;


    boolean login(String username , String password) throws IOException;
}
