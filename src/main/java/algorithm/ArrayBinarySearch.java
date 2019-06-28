package algorithm;

/**
 * <Class description goes here>
 */
public class ArrayBinarySearch {

    static int indexEqualsValueSearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int i = 0;
        while (start <= end) {
            i = (start + end)/2;
            if (arr[i] - i < 0) {
                start = i + 1;
            } else if (arr[i] - i == 0 && (i==0 || arr[i-1] - (i-1) < 0)) {
                return i;
            } else {
                end = i-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] input = {-8,0,2,5,5,5,5};
        System.out.println(indexEqualsValueSearch(input));
    }
}
