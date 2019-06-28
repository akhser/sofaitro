package algorithm;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * <Class description goes here>
 */
public class AscSort {
    private static Comparable[] aux;
    static Comparable[] input = {6, 5, 4, 3, 2, 1};
    public static void main(String[] args) throws FileNotFoundException {
        aux = new Comparable[input.length];
        sort(input);

        System.out.println(Arrays.toString(input));
    }

    private static void sort (Comparable[] a) {
        int N = a.length;
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N-sz; lo += sz + sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    private static void merge (Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = (int) a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less (Comparable a, Comparable b) {
        System.out.println(a + " : " + b);
        return (a.compareTo(b) < 0);
    }
}
