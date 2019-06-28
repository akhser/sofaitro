package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <Class description goes here>
 */
public class PreOrderTraversal {

    private static List<Integer> preOrderTraversal (Node node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.empty()) {
            Node nod = stack.pop();
            result.add(nod.getValue());

            if (nod.getRight() != null) {
                stack.push(nod.getRight());
            }

            if (nod.getLeft() != null) {
                stack.push(nod.getLeft());
            }
        }

        return result;
    }

}
