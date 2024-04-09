package edu.iu.nibomm.primesservice.controller;

import edu.iu.nibomm.primesservice.rabbitmq.MQSender;
import edu.iu.nibomm.primesservice.service.IPrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class primeController {
    @Autowired
    IPrimeService primeService;

    private final MQSender mqSender;
    public  primeController(IPrimeService primeService , MQSender mqSender){
        this.primeService = primeService;
        this.mqSender = mqSender;
    }
    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n){
        boolean result = primeService.isPrime(n);
        mqSender.sendMessage(n,result);
        return result;
    }
}
