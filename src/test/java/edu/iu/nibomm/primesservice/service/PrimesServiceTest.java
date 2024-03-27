package edu.iu.nibomm.primesservice.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimesServiceTest {

    PrimesService primesService = new PrimesService() ;

    @Test
    void isPrime() {
        int n = 3;
        boolean expected = true;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected,actual);
    }

    @Test
    void _56789023456789isPrime() {
        long n = 5678902345678945678L;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected,actual);
    }


}