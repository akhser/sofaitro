package algorithm;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) throws FileNotFoundException {

        String [] a = {"14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort (Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i = h; i<N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h = h/3;
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
