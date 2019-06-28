package algorithm;// Max Average

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MaxAverage {

    public static void main(String[] args) {
        String [][] input = new String[][] {{"A", "5"}, {"B", "2"}, {"C", "3"}, {"A", "2"}};
        rr(input);

    }

    private static double rr (String [][] input) {
        Map<String, double[]> map = new HashMap<>();
        Stream<String[]> temp = Arrays.stream(input);
        Stream<String> stringStream = temp.flatMap(Arrays::stream);
        final String[] currentUser = {null};
        stringStream.forEach(x -> {
            if (x.chars().allMatch(Character::isDigit)) {
                double [] array = map.get(currentUser[0]);
                array[0] = array[0] + 1;
                array[1] = array[1] + Integer.valueOf(x);
            } else {
                currentUser[0] = x;
                if (map.get(x) == null) {
                    map.put(x, new double[]{0,0});
                }
            }
        });

        double average = 0.0;
        for (Map.Entry<String, double[]> pair : map.entrySet()) {
            System.out.println(pair.getKey() + "; " + Arrays.toString(pair.getValue()));

            double [] array = pair.getValue();

            System.out.println("array[1]/array[0] : " + array[1]/array[0]);

            if (array[1]/array[0] > average) {
                average = array[1]/array[0];
            }
        }
        return average;

    }
}
