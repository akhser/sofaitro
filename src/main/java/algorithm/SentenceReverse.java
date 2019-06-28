package algorithm;

import java.util.Arrays;

/**
 * <One possible solution is doing a linear iteration on arr while pushing a copy of every word to a stack and then pulling them in reverse order while copying the words back into arr. Another approach is initializing a new array at the same length, iterating over arr from right to left and copying any sequence of characters to the new array from left to right. Both approaches take O(N) time and at least O(N) space.

 A more elegant and efficient approach is to reverse all the characters in arr and then reverse the characters in each word separately. While the first reverse gives us the words in the reverse order as we wanted, it also reverses the characters of each word. To fix that, we do the second reverse, which reverses each word separately.

 Reversing items in an array is done by a ‘mirror’ function, that swaps the items of every 2 indices with the same distance from the middle.


 */
public class SentenceReverse {
    public static void main(String[] args) {
        char[] input = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
        System.out.println(reverseWords(input));
    }

    static char[] reverseWords(char[] arr) {
        swap(arr, 0, arr.length - 1);
        int wordStart = -1;
        for (int i = 0; i < arr.length -1; i++) {
            if (arr[i] == ' ') {
                if (wordStart != -1) {
                    swap(arr, wordStart, i-1);
                    wordStart = -1;
                }
            } else if (i == arr.length - 1) {
                if (wordStart == -1) {
                    swap(arr, wordStart, i);
                }
            } else {
                if (wordStart == -1) {
                    wordStart = i;
                }
            }
        }
        return arr;
    }

    static void swap (char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }

        System.out.println(Arrays.toString(arr));

    }
}
