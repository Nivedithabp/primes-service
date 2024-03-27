package edu.iu.nibomm.primesservice.controller;

import edu.iu.nibomm.primesservice.service.IPrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class primeController {
    @Autowired
    IPrimeService primeService;

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n){
        return primeService.isPrime(n);
    }
}
