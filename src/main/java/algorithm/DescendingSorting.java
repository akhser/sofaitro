package algorithm;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class DescendingSorting {
    private static Comparable[] aux;
    static Comparable[] input = {6, 5, 4, 3, 2, 1};
    public static void main(String[] args) throws FileNotFoundException {
        aux = new Comparable[input.length];
        sort(input, 0, input.length -1);

        System.out.println(Arrays.toString(input));
    }

    private static void sort (Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
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
