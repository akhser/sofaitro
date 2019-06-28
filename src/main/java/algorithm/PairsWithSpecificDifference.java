package algorithm;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <Class description goes here>
 */
public class PairsWithSpecificDifference {
    public static void main(String[] args) throws InterruptedException {

        int [] a = {4, 1};
        int k = 3;

        System.out.println(Arrays.deepToString(qq(a, k)));

    }

    private static int[][] qq (int [] input, int k) {
        Map<Integer, Integer> output = new LinkedHashMap<>();
        Map<Integer, Integer> mapping = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            mapping.put(input[i] - k, input[i]);
        }

        for (int j = 0; j < input.length; j++) {
            if (mapping.get(input[j]) != null) {
                output.put(mapping.get(input[j]), input[j]);
            }
        }

        int[][] array = new int[mapping.size() - 1][2];
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : output.entrySet()){
            array[count][0] = entry.getKey();
            array[count][1] = entry.getValue();
            count++;
        }
        return array;
    }
}
