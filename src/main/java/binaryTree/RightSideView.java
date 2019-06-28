package binaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {


    private static List<Integer> qq (Node node) {
        List<Integer> result = new ArrayList<>();
        if(node == null) return result;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (queue.size() > 0) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Node top = queue.remove();

                if (i == 0) {
                    result.add(top.getValue());
                }

                if (top.getRight() != null) {
                    queue.add(top.getRight());
                }

                if (top.getLeft() != null) {
                    queue.add(top.getLeft());
                }
            }
        }

        return result;
    }

}
