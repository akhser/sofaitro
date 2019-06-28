package algorithm;

/**
 * <Class description goes here>
 */
public class countYZ {

    public static void main(String[] args) {
        String s = "!!day--yaz!!";
        System.out.println(countYZ(s));
    }

    public static int countYZ(String str) {
        char wordEnd = 'e';
        int count = 0;
        for (Character c: str.toCharArray()) {
            if ((c == ' ' || !Character.isLetter(c)) && (wordEnd == 'y' || wordEnd == 'z' || wordEnd == 'Y' || wordEnd == 'Z')) {
                count ++;
                wordEnd = c;
            } else {
                wordEnd = c;
            }
        }

        if (wordEnd == 'y' || wordEnd == 'z' || wordEnd == 'Y' || wordEnd == 'Z') count ++;

        return count;
    }

}
