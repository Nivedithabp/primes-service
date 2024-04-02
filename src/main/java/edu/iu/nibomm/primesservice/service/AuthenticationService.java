package edu.iu.nibomm.primesservice.service;

import edu.iu.nibomm.primesservice.model.Customer;
import edu.iu.nibomm.primesservice.repository.AuthenticationDBRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class AuthenticationService implements IAuthenticationService , UserDetailsService {

//    IAuthenticationRepository authenticationRepository;
AuthenticationDBRepository authenticationRepository;
    public AuthenticationService(AuthenticationDBRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public boolean register(Customer customer) throws IOException {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String passwordEncoded = bc.encode(customer.getPassword());
        customer.setPassword(passwordEncoded);
        Customer savedCustomer = authenticationRepository.save(customer);
        return savedCustomer != null;
    }


    @Override
    public boolean login(String username, String password) throws IOException {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        try {
            Customer customer = authenticationRepository.findByUsername(username);
            if(customer == null ){
                throw new UsernameNotFoundException("");
            }
            return User
                    .withUsername(username)
                    .password(customer.getPassword())
                    .build();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
