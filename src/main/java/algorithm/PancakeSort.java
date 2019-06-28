package algorithm;

import java.util.Arrays;

public class PancakeSort {
    public static void main(String[] args) {
        int [] input = {1};
        int [] result = pancakeSort(input);
        System.out.println("result: " + Arrays.toString(result));
    }

    static int[] pancakeSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = maxIndex(arr, i);
            flip(arr, maxIndex);
            flip(arr, i);
        }
        return arr;
    }

    private static void flip(int [] input, int count) {
        for (int i = 0; i <= count/2; i++) {
            int temp = input[count - i];
            input[count -i] = input[i];
            input[i] = temp;
        }
    }

    private static int maxIndex (int [] input, int amount) {
        int maxIndex = 0;
        for (int i = 0; i <= amount; i++) {
            if (input[i] > input[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }
}
