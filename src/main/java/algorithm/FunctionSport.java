package algorithm;

/**
 * Implement function q where
 *
 * q(1) = 1;
 * q(2) = 2;
 *
 * q(n) = q(n-q(n-1)) + q(n-q(n-2)) for all n>2;
 */
public class FunctionSport {
    private static int q(int input) {
        int [] array = new int[input];

        array[0] = 1;
        array[1] = 2;

        for (int i = 2; i < input; i++) {
            array[i] = array[i - array[i-1]] + array[i - array[i-2]];
            System.out.println("------------------------------------------------");
            System.out.println("i = " + i);
            System.out.println("array[i-1] = " + array[i-1] );
            System.out.println("array[i - array[i-1]] = " + array[i - array[i-1]]);
            System.out.println("array[i-2] = " + array[i-2] );
            System.out.println("array[i - array[i-2]] = " + array[i - array[i-2]]);
            System.out.println("array[" + i + "] = " + array[i]);
        }
        return array[input - 1];
    }

    public static void main(String[] args) {
        int i = 77;
        System.out.println("q(" + i + ")= " + q(i));
    }
}
