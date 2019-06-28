package binaryTree;

/**
 * <Class description goes here>
 */
public class BalancedTree {

    public static Node getBalancedTree (int[] input) {
        if (input.length == 0) {
            return null;
        }

        return makeTree(input, 0, input.length -1);
    }

    public static Node makeTree (int[] i, int start, int end) {
        if (start > end)
            return null;

        int middle = (start + end)/2;

        Node node = new Node(i[middle]);
        node.setLeft(makeTree(i, start, middle - 1));
        node.setRight(makeTree(i, middle + 1, end));

        return node;

    }
}
