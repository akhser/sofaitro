package algorithm;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) throws FileNotFoundException {

        String [] a = {"D", "B", "C", "A"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort (Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for(int j=i; j>0 && less(a[j], a[j-1]); j--) {
//                System.out.println(a[j] + " : " + a[j-1]);
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less (Comparable a, Comparable b) {
        System.out.println(a + " : " + b);
        return (a.compareTo(b) < 0);
    }

    private static void exch (Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
