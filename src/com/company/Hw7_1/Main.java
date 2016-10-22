package com.company.Hw7_1;

public class Main {
public static int count=0;

    public static void main(String[] args) throws InterruptedException {
        Incrementer inc = new Incrementer();
        Decrementer dec = new Decrementer();
        inc.setName("Increment");
        dec.setName("Decrement");
        inc.setDecr(dec);
        dec.setIncr(inc);
        inc.start();
        dec.start();




    }
}
