package algorithm;

/**
 * <Class description goes here>
 */
public class BracketMatch {
    public static void main(String[] args) {
        String s = "())(";
        int result = bracketMatch(s);
        System.out.println(result < 0 ? result * -1 : result);
    }

    static int bracketMatch(String text) {
        int open = 0;
        int closed = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '(' ) {
                open ++;
            } else if (text.charAt(i) == ')') {
                if (open > 0) {
                    open --;
                } else {
                    closed ++;
                }
            }
        }
        return open + closed;
    }
}
