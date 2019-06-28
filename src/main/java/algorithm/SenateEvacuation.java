package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

//https://codingcompetitions.withgoogle.com/codejam/round/0000000000000130/00000000000004c0
public class SenateEvacuation {

    private static String[]out = new String[] {};

    public static void main(String[] args) throws FileNotFoundException {
        long start = new Date().getTime();

        Scanner input = new Scanner(new File("/home/user/in.txt"));
        int testCases = 0;
        int readLineNumbers = 2;
        int counter = 0;

        double[] countOfPeople = null;

        while(input.hasNextLine())
        {
            // read first line
            if (testCases == 0) {
                testCases = Integer.valueOf(input.nextLine());
                continue;
            }

            if (counter < readLineNumbers) {
                if (counter == 0) {
                    countOfPeople = new double[Integer.valueOf(input.nextLine())];
                }
                if (counter == 1) {
                    countOfPeople = Arrays.stream(input.nextLine().split("\\s")).mapToDouble(Integer::parseInt).toArray();
                }

                counter++;
            }

            if (counter == readLineNumbers && testCases != 0) {
                counter = 0;
                testCases --;

                double[][] withPercentage = setPercentage(countOfPeople);
                rr(withPercentage);
                System.out.println("Case #" +  testCases+  " : " + Arrays.deepToString(out));
            }

        }

        System.out.println("Takes " + (new Date().getTime() - start) + " ms.");
    }

    private static void rr(double[][] input) {
        System.out.println("input: " + Arrays.deepToString(input));
        int capacity = 2;
        boolean allowed;

        //capacity = 2, remove from one party
        for (int i = 0; i < input.length; i++) {
            if (input[i][0] - capacity >= 0) {
                input[i][0] = input[i][0] - capacity;
                updatePercentage(input);
                if (input[i][0] >= 0) {
                    if (checkPercentage(input)) {
                        //System.out.println("YES: " + Arrays.deepToString(input));
                        append(out, getCharForNumber(i+1) + getCharForNumber(i+1));
                        if (!ret(input)) {
                            rr(input);
                        }
                    } else {
                        //System.out.println("NO: " + Arrays.deepToString(input));
                        input[i][0] = input[i][0] + capacity;
                        updatePercentage(input);
                    }
                }
            }
        }

        //capacity = 1, remove from one party
        capacity --;
        for (int i = 0; i < input.length; i++) {
            if (input[i][0] - capacity >= 0) {
                input[i][0] = input[i][0] - capacity;
                updatePercentage(input);
                if (input[i][0] >= 0) {
                    if (checkPercentage(input)) {
                        //System.out.println("YES 2: " + Arrays.deepToString(input));
                        append(out, getCharForNumber(i+1));
                        if (!ret(input)) {
                            rr(input);
                        }
                    } else {
                        //System.out.println("NO 2: " + Arrays.deepToString(input));
                        input[i][0] = input[i][0] + capacity;
                        updatePercentage(input);
                    }
                }
            }
        }

        //capacity = 2, remove 1 from each party
        capacity++;
        int counter = 0;
        int i;
        for (i = 0; i < input.length; i++) {
            if (counter < capacity) {
                if (input[i][0] - 1 >= 0) {
                    input[i][0] = input[i][0] - 1;
                    counter++;
                }
            }
        }
        updatePercentage(input);
        if (checkPercentage(input)) {
            //System.out.println("YES 3: " + Arrays.deepToString(input));
            append(out, getCharForNumber(i-1) + getCharForNumber(i));
            if (!ret(input)) {
                rr(input);
            }
        } else {
            //System.out.println("NO 3: " + Arrays.deepToString(input));
            for (i = 0; i < input.length; i++) {
                if (counter != 0) {
                    input[i][0] = input[i][0] + 1;
                    counter--;
                }
            }
        }
    }


    private static double [][] setPercentage(double[] input) {
        double total = 0;
        for (double d: input) {
            total += d;
        }

        double [][] output = new double[input.length][2];
        for (int i = 0; i<input.length; i++) {
            output[i][0] = input[i];
            output[i][1] = input[i]/total;
        }

        return output;
    }

    private static double getTotal (double[][] input) {
        double total = 0;
        for (double[] d: input) {
            total += d[0];
        }
        return total;
    }

    private static boolean updateAndCheckPercentage(double[][] input) {
        double total = getTotal(input);

        for (int i = 0; i < input.length; i++) {
            if (input[i][0] != 0.0) {
                input[i][1] = input[i][0]/total;
            } else {
                input[i][1] = 0.0;
            }
        }


        boolean allowed = true;
        double percentage = 0.5;
        for (int i = 0; i<input.length; i++) {
            if (input[i][1] > percentage) {
                allowed = false;
            }
        }
        return allowed;
    }

    private static void updatePercentage(double[][] input) {
        double total = getTotal(input);

        for (int i = 0; i < input.length; i++) {
            if (input[i][0] != 0.0) {
                input[i][1] = input[i][0]/total;
            } else {
                input[i][1] = 0.0;
            }
        }
    }

    private static boolean checkPercentage(double[][] input) {
        boolean allowed = true;
        double percentage = 0.5;
        for (int i = 0; i<input.length; i++) {
            if (input[i][1] > percentage) {
                allowed = false;
            }
        }
        return allowed;
    }

    private static <T> T[] append(T[] arr, T element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        out = (String[]) arr;
        return null;
    }

    private static String getCharForNumber(int i) {
        return i >= 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
    }

    private static boolean ret (double[][] input) {
        // check if need to return;
        boolean ret = true;
        for (int i = 0; i < input.length; i++) {
            if (input[i][0] != 0.0) {
                ret = false;
            }
        }
        return ret;
    }
}
