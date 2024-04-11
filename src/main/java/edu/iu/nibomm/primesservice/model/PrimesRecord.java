package edu.iu.nibomm.primesservice.model;

public class PrimesRecord {

    private String customer;
    private int n;
    private boolean isPrime;

    public PrimesRecord(String customer, int n, boolean isPrime) {
        this.customer = customer;
        this.n = n;
        this.isPrime = isPrime;
    }


    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }
}
