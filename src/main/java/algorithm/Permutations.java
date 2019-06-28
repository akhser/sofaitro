package algorithm;//Calculate and print all permutations for string

import java.util.Arrays;
import java.util.Date;

public class Permutations {

    static int count = 0;

    public static void main(String[] args) {
        long start = new Date().getTime();

        String s = "12345";
        String [] input = s.split("");
        String [] emptyArray = new String[] {};

        rr(emptyArray, input);
        System.out.println("Count of permutations: " + count);

        System.out.println("Takes " + (new Date().getTime() - start) + " ms.");
    }

    private static void rr(String [] prefix, String [] postfix) {
        if (prefix.length == 0 && postfix.length < 2) {
            return;
        }

        if (postfix.length == 2) {
            count = count + 2;
            System.out.println(String.join("", prefix) + postfix[0] + postfix[1]);
            System.out.println(String.join("", prefix) + postfix[1] + postfix[0]);
        }

        if (postfix.length > 2) {
            for (int i = 0; i < postfix.length; i++) {
                String[] r = removeElement(postfix, i);
                rr(append(prefix, postfix[i]), removeElement(postfix, i));
            }
        }
    }

    private static <T> T[] removeElement(T[] postfix, int position) {
        T [] forReturn = Arrays.copyOf(postfix, postfix.length - 1);
        for (int i = 0; i < postfix.length; i++) {
            if (i < position) {
                forReturn[i] = postfix[i];
            } else if (i > position) {
                forReturn[i-1] = postfix[i];
            }
        }
        return forReturn;
    }

    private static <T> T[] append(T[] arr, T element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }

}
