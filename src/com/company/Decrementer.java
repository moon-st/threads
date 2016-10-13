package com.company;

import java.util.Random;

/**
 * Created by Moonst on 11.10.2016.
 */
public class Decrementer extends Thread {
    Incrementer inc;
    public void setIncr(Incrementer inc){
        this.inc = inc;
    }

    @Override
    public void run() {
        if (!Thread.interrupted()){
            for (int i = 0; i <100 ; i++) {

                try {
                    Main.count--;
                    log(Main.count);
                    Thread.sleep((new Random().nextInt(250))+50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    return;

                }

            }    if (inc.isAlive()){
                inc.interrupt();
                System.out.println("Decrementer win "+ Main.count);
        }


        }else return;


    }
    private static void log(int val){
        System.out.println(Thread.currentThread().getName()+" "+val);
    }
}
