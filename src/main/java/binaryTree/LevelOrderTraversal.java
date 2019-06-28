package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

    private static List<List<Integer>> levelOrderTraversal (Node node) {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node n = queue.pop();
                list.add(n.getValue());

                if (n.getLeft() != null) {
                    queue.add(n.getLeft());
                }

                if (n.getRight() != null) {
                    queue.add(n.getRight());
                }
            }

            result.add(list);
        }

        return result;
    }

}
