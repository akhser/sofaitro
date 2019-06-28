package algorithm;

import java.util.Arrays;

/**
 * <Class description goes here>
 */
public class MergeSortedArraysInProgress {
    public static void main(String[] args) {
        int[] a1 = new int[] {1, 3, 2, 5, 9, 10};
        int[] a2 = new int[] {4, 7, 11};

        int total = a1.length + a2.length;
        int[] merged = new int[total];

        int i1 = 0;
        int i2 = 0;
        int m = 0;

        while (total > 0) {
            if (i2 == -1 || a1[i1] < a2[i2]) {
                merged[m] = a1[i1];
                i1++;
                if (i1 == a1.length)
                    i1 = -1;
            } else {
                merged[m] = a2[i2];
                i2++;
                if (i2 == a2.length)
                    i2 = -1;
            }

            total --;
            m++;
        }

        System.out.println(Arrays.toString(merged));

    }
}
