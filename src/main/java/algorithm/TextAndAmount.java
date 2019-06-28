package algorithm;//        aaa -> a3

public class TextAndAmount {

    public static void main(String[] args) {
        String input = "aaa";
        rr(input);
    }

    private static String rr (String input) {
        StringBuilder sb = new StringBuilder();
        char currentChar = input.charAt(0);
        int amount = 0;
        for (char c : input.toCharArray()) {
            if (currentChar == c) {
                amount ++;
            } else {
                sb.append(currentChar).append(amount);
                currentChar = c;
                amount = 1;
            }
        }
        if (input.length() == amount) {
            return String.valueOf(currentChar + "" + amount);
        }
        if (sb.toString().charAt(sb.toString().length() - 1) != input.charAt(input.length() - 1)) {
            sb.append(currentChar).append(amount);
        }

        return sb.toString();
    }
}
