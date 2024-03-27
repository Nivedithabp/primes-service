package edu.iu.nibomm.primesservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class homeController {
    @GetMapping("/test")
    public String greeting(){
        return "welcome to prime services!!!";
    }
}
