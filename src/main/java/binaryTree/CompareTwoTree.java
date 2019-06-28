package binaryTree;

public class CompareTwoTree {

    private static boolean qq(Node one, Node two) {
        if ((one == null && two != null) || (one != null && two == null)) {
            return false;
        }

        if (one == null && two == null) {
            return true;
        }

        if (one != null && two != null && one.getValue() == two.getValue()) {
            return qq(one.getLeft(), two.getLeft()) && qq(one.getRight(), two.getRight());
        } else {
            return false;
        }
    }
}
