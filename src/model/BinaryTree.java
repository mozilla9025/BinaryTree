package model;

/**
 * Created by Sergey on 15.05.2017.
 */
public class BinaryTree {

    private Node root;

    class Node implements Comparable {

        private Node parent;
        private Node left;
        private Node right;
        private String data;

        public Node(String data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Object o) {
            return data.compareToIgnoreCase(o.toString());
        }

        @Override
        public String toString() {
            return data;
        }
    }


    public BinaryTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void addElement(String value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            addElement(root, newNode);
        }
    }

    public Node getElement(String value) {
        return getElement(root, value);
    }

    public Node getMinimum() {
        return getMinimum(root);
    }

    public Node getMaximum() {
        return getMaximum(root);
    }

    public Node next() {
        return next(root);
    }

    public Node previous() {
        return previous(root);
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    public int size() {
        return size(root);
    }

    public int treeDepth() {
        return treeDepth(root);
    }

    private void addElement(Node root, Node newNode) {
        while (root != null) {
            if (newNode.data.compareTo(root.data) > 0) {
                if (root.right != null) {
                    root = root.right;
                } else {
                    newNode.parent = root;
                    root.right = newNode;
                    break;
                }
            } else if (newNode.data.compareTo(root.data) < 0) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    newNode.parent = root;
                    root.left = newNode;
                    break;
                }
            }
        }
    }

    public Node remove(String value) {
        return remove(root, value);
    }

    private Node getElement(Node root, String value) {
        if (root == null || value.compareTo(root.data) == 0) {
            return root;
        }
        if (value.compareTo(root.data) < 0) {
            return getElement(root.left, value);
        } else {
            return getElement(root.right, value);
        }
    }

    private Node getMinimum(Node root) {
        if (root.left == null) {
            return root;
        }
        return getMinimum(root.left);

    }

    private Node getMaximum(Node root) {
        if (root.right == null) {
            return root;
        }
        return getMaximum(root.right);
    }

    private Node next(Node root) {
        if (root.right != null) {
            return getMinimum(root.right);
        }
        Node leaf = root.parent;
        while (leaf != null && root == leaf.right) {
            root = leaf;
            leaf = leaf.parent;
        }
        return leaf;
    }

    private Node previous(Node root) {
        if (root.left != null) {
            return getMaximum(root.left);
        }
        Node leaf = root.parent;
        while (leaf != null && root == leaf.left) {
            root = leaf;
            leaf = leaf.parent;
        }
        return leaf;
    }


    private void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    private Node remove(Node root, String value) {
        if (root == null) {
            return root;
        }
        if (value.compareTo(root.data) < 0) {
            root.left = remove(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = remove(root.right, value);
        } else if (root.left != null && root.right != null) {
            root.data = getMinimum(root.right).data;
            root.right = remove(root.right, root.data);
        } else {
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    private int size(Node root) {
        if (root == null)
            return 0;
        return size(root.left) + 1 + size(root.right);
    }


    private int treeDepth(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
        }
    }
}
