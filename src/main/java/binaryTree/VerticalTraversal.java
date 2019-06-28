package binaryTree;

import javafx.util.Pair;

import java.util.*;

public class VerticalTraversal {

    private static Map<Integer, List<Integer>> verticalOrderTraversal(Node node) {

        Map<Integer, List<Integer>> result = new TreeMap<>();
        Stack<Pair<Integer, Node>> stack = new Stack<>();
        stack.push(new Pair<>(0, node));

        while (!stack.empty())  {
            Pair<Integer, Node> pair = stack.pop();
            Node nod = pair.getValue();
            updateMap(result, pair.getKey(), nod.getValue());

            if (nod.getRight() != null) {
                stack.push(new Pair<>(pair.getKey() + 1, nod.getRight()));
            }

            if (nod.getLeft() != null) {
                stack.push(new Pair<>(pair.getKey() - 1, nod.getLeft()));
            }
        }

        return result;

    }

    private static void updateMap(Map<Integer, List<Integer>> result, int count, int value) {
        List<Integer> list;
        if (result.containsKey(count)) {
            list = result.get(count);
            list.add(value);
        } else {
            list = new ArrayList<>();
            list.add(value);
        }
        result.put(count, list);
    }
}
