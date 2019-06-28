package binaryTree;


import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    private static List<Integer> postOrderTraversal (Node node) {

        List<Integer> result = new ArrayList<>();
        postOrder(node,  result);
        return result;
    }

    private static void postOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeft(), list);
        postOrder(node.getRight(), list);
        list.add(node.getValue());
    }
}
