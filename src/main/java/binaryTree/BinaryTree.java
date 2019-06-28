package binaryTree;

//BinaryTree bt = new BinaryTree();
//
//bt.add(6);
//        bt.add(4);
//        bt.add(8);
//        bt.add(3);
//        bt.add(5);
//        bt.add(7);
//        bt.add(9);
//        bt.add(10);
//        bt.add(11);
//        bt.add(12);

//                6
//             4      8
//           3   5  7   9
//                       10
//                         11
//                          12

public class BinaryTree {
    Node root;

    public Node getRoot() {
        return root;
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
