package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <Class description goes here>
 */
public class InOrderTraversal {

    private static List<Integer> inOrderTraversal (Node node) {

        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if (node == null) {
            return result;
        }

        Node root = node;

        while (root != null) {
            stack.push(root);
            root = root.getLeft();
        }

        while (!stack.empty()) {
            Node n = stack.pop();
            result.add(n.getValue());

            n = n.getRight();
            while(n != null) {
                stack.push(n);
                n = n.getLeft();
            }
        }

        return result;
    }
}
