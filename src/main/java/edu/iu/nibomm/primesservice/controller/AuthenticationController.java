package edu.iu.nibomm.primesservice.controller;

import edu.iu.nibomm.primesservice.model.Customer;
import edu.iu.nibomm.primesservice.repository.IAuthenticationRepository;
import edu.iu.nibomm.primesservice.service.AuthenticationService;
import edu.iu.nibomm.primesservice.service.IAuthenticationService;
import edu.iu.nibomm.primesservice.service.TokenService;
import org.apache.catalina.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    private final AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/register")
    public boolean register(@RequestBody Customer customer) {
        try {
            return authenticationService.register(customer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                customer.getUsername(),
                                customer.getPassword()
                        )
                );
//        return "success!";
        return tokenService.generateToken(authentication);
    }
}

