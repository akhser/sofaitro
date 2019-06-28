package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <Class description goes here>
 */
public class Duplicates {

    public static void main(String[] args) {
        String s = "qwertq";
        Map<Character, Integer> m = new HashMap<>();

        for(Character c : s.toCharArray()) {
            m.put(c, m.get(c) != null ? m.get(c) + 1 : 1);
            if (m.containsKey(c) && m.get(c) > 1) {
                System.out.print(c.toString() + " ");
            }
        }
    }

}
