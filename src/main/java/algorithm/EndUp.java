package algorithm;

/**
 * <Class description goes here>
 */
public class EndUp {
    public static void main(String[] args) {
        String s = "hi";
        System.out.println(endUp(s));
    }

    public static String endUp(String str) {
        int length = 0;
        String output = "";
        while(length < str.length()) {
            if (length < 3) {
                output = output + "" + Character.toUpperCase(str.charAt(str.length() - 1  - length));
            } else {
                output = output + "" + str.charAt(str.length() - 1  - length);
            }

            length ++;
        }
        return new StringBuilder(output).reverse().toString();
    }
}
