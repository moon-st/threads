package com.company.Hw7_1;

import java.util.Random;

/**
 * Created by Moonst on 11.10.2016.
 */
public class Incrementer extends Thread {
    Decrementer dec;
    public void setDecr(Decrementer dec){
        this.dec = dec;
    }
    @Override
    public void run() {
       if(!Thread.interrupted()){
            for (int i = 0; i <100 ; i++) {
                Main.count++;
                log(Main.count);
                try {
                    Thread.sleep((new Random().nextInt(250))+50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (dec.isAlive()){
                dec.interrupt();
                System.out.println("Incrementer win "+Main.count);
        }

        }else return;

    }
    private static void log(int val){
        System.out.println(Thread.currentThread().getName()+" "+val);
    }
}
