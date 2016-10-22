package com.company.Hw7_2;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Moonst on 22.10.2016.
 */
public class TestArray {
    int arr[];
    Random random = new Random(600);

    public TestArray(int val) {
        this.arr = new int[val];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] =  random.nextInt();
        }
    }

    public  void run(){
        int arrCopy[] = arr.clone();
        long start = System.currentTimeMillis();
        Arrays.sort(arrCopy);
        long stop = System.currentTimeMillis();
        System.out.println("Without Treads "+arr.length+" array: " +(stop-start));
            }
    public void runWithTreads() throws InterruptedException{
        int arrHalfOne[] = Arrays.copyOfRange(arr, 0, arr.length/2);
        int arrHalfTwo[] = Arrays.copyOfRange(arr, arr.length/2, arr.length+1);
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Arrays.sort(arrHalfOne);
              //  System.out.println("1");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Arrays.sort(arrHalfTwo);
                //System.out.println("2");
            }
        });
        thread1.run();
        thread2.run();
        thread1.join();
        thread2.join();
        int[] arrSorted = Main.ArrMerge(arrHalfOne, arrHalfTwo);
        long stop =System.currentTimeMillis();
        System.out.println("With Treads "+arr.length+" array: "+(stop - start));
            }
}
