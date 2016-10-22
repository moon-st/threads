package com.company.Hw7_2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TestArray testArray10k = new TestArray(10_000);
        testArray10k.run();
        testArray10k.runWithTreads();
        TestArray testArray500k = new TestArray(500_000);
        testArray500k.run();
        testArray500k.runWithTreads();
        TestArray testArray5kk = new TestArray(5_000_000);
        testArray5kk.run();
        testArray5kk.runWithTreads();




    }
    public static int[] ArrMerge(int[] a, int[] b){
        int[] result = new int[a.length+b.length];
        int i=0, j=0, index = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[index] = a[i];
                i++;
            } else {
                result[index] = b[j];
                j++;
            }

            index++;
        }
        while (i < a.length ) {
            result[index] = a[i];
            index++;
            i++;
        }

        while (j < b.length) {
            result[index] = b[j];
            index++;
            j++;
        }
        return result;

    }
}
