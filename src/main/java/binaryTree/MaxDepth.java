package binaryTree;

/**
 * <Class description goes here>
 */
public class MaxDepth {

    public static int qq (Node node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = qq(node.getLeft());
        int rightDepth = qq(node.getRight());

        int max = Math.max(leftDepth, rightDepth);

        return max + 1;
    }

}
